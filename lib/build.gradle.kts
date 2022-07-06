repositories.mavenCentral()

plugins {
    id("io.gitlab.arturbosch.detekt") version Version.detekt
    id("org.jetbrains.kotlin.jvm")
}

tasks.getByName<JavaCompile>("compileJava") {
    targetCompatibility = Version.jvmTarget
}

val compileKotlinTask = tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlin") {
    kotlinOptions {
        jvmTarget = Version.jvmTarget
        freeCompilerArgs = freeCompilerArgs + setOf("-module-name", Maven.groupId + ":" + Maven.artifactId)
    }
}

tasks.getByName<JavaCompile>("compileTestJava") {
    targetCompatibility = Version.jvmTarget
}

tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileTestKotlin") {
    kotlinOptions.jvmTarget = Version.jvmTarget
}

setOf("main", "test").forEach { source ->
    val detektTask = tasks.getByName<io.gitlab.arturbosch.detekt.Detekt>("detekt${source.capitalize()}")
    val configs = setOf(
        "common",
        "comments",
        "complexity",
        "coroutines",
        "empty-blocks",
        "exceptions",
        "naming",
        "performance",
        "potential-bugs",
        "style"
    ).map { config ->
        File(rootDir, "buildSrc/src/main/resources/detekt/config/$config.yml").existing()
    }
    task<io.gitlab.arturbosch.detekt.Detekt>("verifyCodeQuality${source.capitalize()}") {
        jvmTarget = Version.jvmTarget
        setSource(files("src/$source/kotlin"))
        config.setFrom(configs)
        reports {
            xml.required.set(false)
            sarif.required.set(false)
            txt.required.set(false)
            html {
                required.set(true)
                outputLocation.set(File(buildDir, "reports/analysis/code/quality/${source}/html/index.html"))
            }
        }
        classpath.setFrom(detektTask.classpath)
    }
}
