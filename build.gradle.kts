val koin_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.3.0"
    id("io.ktor.plugin") version "3.4.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.3.0"
}

group = "org.delcom"
version = "0.0.1"

application {
    // Memastikan entry point aplikasi sesuai dengan file Application.kt Anda
    mainClass.set("org.delcom.ApplicationKt")
}

// Perbaikan: Menentukan toolchain agar Gradle menggunakan Java 25 di komputer Anda
kotlin {
    jvmToolchain(25)
}

dependencies {
    // Ktor Server Libraries
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-server-cors")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("io.ktor:ktor-server-netty")
    implementation("io.ktor:ktor-server-config-yaml")

    // Dependency Injection (Koin)
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation("io.insert-koin:koin-logger-slf4j:$koin_version")

    // Logging
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // Perbaikan: Menambahkan library dotenv yang sebelumnya "Unresolved reference"
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // Testing
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}