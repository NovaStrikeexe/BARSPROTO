plugins {
    java
    kotlin("jvm") version "1.5.30"
    id("org.openjfx.javafxplugin") version "0.0.9"
    application
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls", "javafx.graphics")
}

group = "ru.kgsu"
version = "1.0-SNAPSHOT"


tasks {
    val java = "11"

    compileKotlin {
        kotlinOptions { jvmTarget = java }
        sourceCompatibility = java
    }

    compileTestKotlin {
        kotlinOptions { jvmTarget = java }
        sourceCompatibility = java
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the tornadofx
    implementation("no.tornado:tornadofx:1.7.20")
}
