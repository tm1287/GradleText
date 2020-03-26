plugins {
    kotlin("jvm") version "1.3.61"
    `java-gradle-plugin`
    `maven-publish`
    id("nu.studer.credentials") version "2.1"
    id("com.gradle.plugin-publish") version "0.10.1"
    id("com.tejasm.gradle.gradletext") version "1.0.0"
}

group = "com.tejasm.gradle"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(gradleApi())
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

gradlePlugin {
    plugins {
        create("GradleText") {
            id = "com.tejasm.gradle.gradletext"
            displayName = "Gradle Text Plugin"
            description = "A plugin that notifies a user of build status via SMS"
            implementationClass = "com.tejasm.gradle.GradleTextPlugin"
        }
    }
}

val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets.main.get().allSource)
}

publishing {
    repositories {
        maven {
            // change to point to your repo, e.g. http://my.org/repo
            url = uri("$buildDir/repo")
        }
    }
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}

pluginBundle {
    website = "http://example.com"
    vcsUrl = "https://github.com/tm1287/GradleText"
    tags = listOf("SMS", "text", "build", "fail")
}





