repositories.mavenCentral()

plugins {
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

"Snapshot".also { variant ->
    val versionName = Version.name + "-" + variant.toUpperCase()
    task<Jar>("assemble${variant}Jar") {
        dependsOn(compileKotlinTask)
        archiveBaseName.set(Maven.artifactId)
        archiveVersion.set(versionName)
        from(compileKotlinTask.destinationDirectory.asFileTree)
    }
}
