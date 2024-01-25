plugins {
    val kotlinVersion = "1.8.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.16.0"
}

group = "top.enkansakura"
version = "1.0.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

mirai {
    jvmTarget = JavaVersion.VERSION_17
}

dependencies {
    implementation(platform("io.ktor:ktor-bom:2.3.7"))
    implementation("io.ktor:ktor-client")
    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-client-json")
    implementation("io.ktor:ktor-client-okhttp")
}