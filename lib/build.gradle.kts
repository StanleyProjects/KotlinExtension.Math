import sp.gx.core.Badge
import sp.gx.core.GitHub
import sp.gx.core.Markdown
import sp.gx.core.Maven
import sp.gx.core.assemble
import sp.gx.core.camelCase
import sp.gx.core.check
import sp.gx.core.colonCase
import sp.gx.core.existing
import sp.gx.core.file
import sp.gx.core.filled
import sp.gx.core.kebabCase
import sp.gx.core.resolve
import java.net.URL

version = "0.4.3"

val maven = Maven.Artifact(
    group = "com.github.kepocnhh",
    id = rootProject.name,
)

val gh = GitHub.Repository(
    owner = "StanleyProjects",
    name = rootProject.name,
)

repositories.mavenCentral()

plugins {
    id("io.gitlab.arturbosch.detekt") version Version.detekt
    id("org.gradle.jacoco")
    id("org.jetbrains.dokka") version Version.dokka
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Version.jupiter}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Version.jupiter}")
}

jacoco.toolVersion = Version.jacoco

tasks.getByName<JavaCompile>("compileJava") {
    targetCompatibility = Version.jvmTarget
}

val compileKotlinTask = tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlin") {
    kotlinOptions {
        jvmTarget = Version.jvmTarget
        freeCompilerArgs = freeCompilerArgs + setOf("-module-name", colonCase(maven.group, maven.id))
    }
}

tasks.getByName<JavaCompile>("compileTestJava") {
    targetCompatibility = Version.jvmTarget
}

tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileTestKotlin") {
    kotlinOptions.jvmTarget = Version.jvmTarget
}

val taskUnitTest = task<Test>("checkUnitTest") {
    useJUnitPlatform()
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
}

val taskCoverageReport = task<JacocoReport>("assembleCoverageReport") {
    dependsOn(taskUnitTest)
    reports {
        csv.required.set(false)
        html.required.set(true)
        xml.required.set(false)
    }
    sourceDirectories.setFrom(file("src/main/kotlin"))
    classDirectories.setFrom(sourceSets.main.get().output.classesDirs)
    executionData(taskUnitTest)
    doLast {
        val report = buildDir.resolve("reports/jacoco/$name/html/index.html")
        if (report.exists()) {
            println("Coverage report: ${report.absolutePath}")
        }
    }
}

task<JacocoCoverageVerification>("checkCoverage") {
    dependsOn(taskCoverageReport)
    violationRules {
        rule {
            limit {
                minimum = BigDecimal(0.96)
            }
        }
    }
    classDirectories.setFrom(taskCoverageReport.classDirectories)
    executionData(taskCoverageReport.executionData)
}

setOf("main", "test").also { types ->
    val configs = setOf(
        "comments",
        "common",
        "complexity",
        "coroutines",
        "empty-blocks",
        "exceptions",
        "naming",
        "performance",
        "potential-bugs",
        "style",
    ).map { config ->
        rootDir.resolve("buildSrc/src/main/resources/detekt/config/$config.yml")
            .existing()
            .file()
            .filled()
    }
    types.forEach { type ->
        task<io.gitlab.arturbosch.detekt.Detekt>(camelCase("check", "CodeQuality", type)) {
            jvmTarget = Version.jvmTarget
            source = sourceSets.getByName(type).allSource
            config.setFrom(configs)
            reports {
                html {
                    required.set(true)
                    outputLocation.set(buildDir.resolve("reports/analysis/code/quality/$type/html/index.html"))
                }
                md.required.set(false)
                sarif.required.set(false)
                txt.required.set(false)
                xml.required.set(false)
            }
            val detektTask = tasks.getByName<io.gitlab.arturbosch.detekt.Detekt>(camelCase("detekt", type))
            classpath.setFrom(detektTask.classpath)
        }
    }
}

task<io.gitlab.arturbosch.detekt.Detekt>("checkDocumentation") {
    val configs = setOf(
        "common",
        "documentation",
    ).map { config ->
        rootDir.resolve("buildSrc/src/main/resources/detekt/config/$config.yml")
            .existing()
            .file()
            .filled()
    }
    jvmTarget = Version.jvmTarget
    source = sourceSets.main.get().allSource
    config.setFrom(configs)
    reports {
        html {
            required.set(true)
            outputLocation.set(buildDir.resolve("reports/analysis/documentation/html/index.html"))
        }
        md.required.set(false)
        sarif.required.set(false)
        txt.required.set(false)
        xml.required.set(false)
    }
    val detektTask = tasks.getByName<io.gitlab.arturbosch.detekt.Detekt>("detektMain")
    classpath.setFrom(detektTask.classpath)
}

"snapshot".also { variant ->
    val version = kebabCase(version.toString(), variant.toUpperCase())
    task<Jar>(camelCase("assemble", variant, "Jar")) {
        dependsOn(compileKotlinTask)
        archiveBaseName.set(maven.id)
        archiveVersion.set(version)
        from(compileKotlinTask.destinationDirectory.asFileTree)
    }
    task<Jar>(camelCase("assemble", variant, "Source")) {
        archiveBaseName.set(maven.id)
        archiveVersion.set(version)
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
    task(camelCase("assemble", variant, "Pom")) {
        doLast {
            buildDir.resolve("libs/${kebabCase(maven.id, version)}.pom").assemble(
                Maven.pom(
                    groupId = maven.group,
                    artifactId = maven.id,
                    version = version,
                    packaging = "jar",
                ),
            )
        }
    }
    task(camelCase("assemble", variant, "MavenMetadata")) {
        doLast {
            buildDir.resolve("xml/maven-metadata.xml").assemble(
                Maven.metadata(
                    groupId = maven.group,
                    artifactId = maven.id,
                    version = version,
                ),
            )
        }
    }
    task<org.jetbrains.dokka.gradle.DokkaTask>(camelCase("assemble", variant, "Documentation")) {
        outputDirectory.set(buildDir.resolve("documentation/$variant"))
        moduleName.set(gh.name)
        moduleVersion.set(version)
        dokkaSourceSets.getByName("main") {
            val path = "src/$name/kotlin"
            reportUndocumented.set(false)
            sourceLink {
                localDirectory.set(file(path))
                val url = GitHub.url(gh.owner, gh.name)
                remoteUrl.set(URL("$url/tree/${moduleVersion.get()}/lib/$path"))
            }
            jdkVersion.set(Version.jvmTarget.toInt())
        }
    }
    task(camelCase("assemble", variant, "Metadata")) {
        doLast {
            buildDir.resolve("yml/metadata.yml").assemble(
                """
                    repository:
                     owner: '${gh.owner}'
                     name: '${gh.name}'
                    version: '$version'
                """.trimIndent(),
            )
        }
    }
    task(camelCase("check", variant, "Readme")) {
        doLast {
            val badge = Markdown.image(
                text = "version",
                url = Badge.url(
                    label = "version",
                    message = version,
                    color = "2962ff",
                ),
            )
            val expected = setOf(
                badge,
                Markdown.link("Maven", Maven.Snapshot.url(maven.group, maven.id, version)),
                Markdown.link("Documentation", GitHub.pages(gh.owner, gh.name).resolve("doc").resolve(version)),
                "implementation(\"${maven.group}:${maven.id}:$version\")",
            )
            rootDir.resolve("README.md").check(
                expected = expected,
                report = buildDir.resolve("reports/analysis/readme/index.html"),
            )
        }
    }
}
