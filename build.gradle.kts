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
    implementation("org.openjfx:javafx-controls:17.0.1")
    implementation("org.openjfx:javafx-fxml:17.0.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}