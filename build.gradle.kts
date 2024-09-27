plugins {
    kotlin("jvm") version "1.9.23"
    application
}

group = "fr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}