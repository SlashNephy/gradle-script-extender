plugins {
    kotlin("jvm") version "1.4.30"

    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.12.0"
}

group = "blue.starry"
version = System.getenv("VERSION")

pluginBundle {
    website = "https://github.com/SlashNephy/gradle-script-extender"
    vcsUrl = "https://github.com/SlashNephy/gradle-script-extender"
    tags = listOf("gradle", "kotlin")
}

gradlePlugin {
    plugins {
        create("script-extender") {
            id = "blue.starry.scriptextender"
            displayName = "gradle-script-extender"
            description = "\uD83D\uDC18 A Gradle plugin which extends the existing Gradle Kotlin DSL."
            implementationClass = "blue.starry.scriptextender.ScriptExtenderPlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation(kotlin("stdlib"))
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}
