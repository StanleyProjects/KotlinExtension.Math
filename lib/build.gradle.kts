repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.jvm")
}

tasks.getByName<JavaCompile>("compileJava") {
    targetCompatibility = "1.8"
}

tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlin") {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + setOf("-module-name", "StanleyProjects:KotlinExtension.Math") // todo
    }
}

tasks.getByName<JavaCompile>("compileTestJava") {
    targetCompatibility = "1.8"
}

tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileTestKotlin") {
    kotlinOptions.jvmTarget = "1.8"
}
