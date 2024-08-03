plugins {
    kotlin("jvm") version "2.0.0" apply false
    kotlin("multiplatform") version "2.0.0" apply false
    kotlin("android") version "2.0.0" apply false
    kotlin("plugin.serialization") version "2.0.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.dokka") version "1.9.20"
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.13.2"
    id("pkce.variables")
}

tasks.named<org.jetbrains.dokka.gradle.DokkaMultiModuleTask>("dokkaGfmMultiModule").configure {
    outputDirectory.set(file("${projectDir.path}/docs"))
}

group = buildVariables.group
version = buildVariables.version
