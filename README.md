# Gradle SMS Notifications
Ever take a break during a Gradle build, get up to go get some coffee only to return to the disappointment that is a failed build? This plugin notifies you via SMS messaging so you can prepare for the grueling task of debugging and rebuilding.

# Status
Incomplete - Currently undergoing development

# Usage
Currently, this plugin publishes to a local Maven repository located at `build/repo`. If checkout out, the plugin can be build by running the task
`gradlew publish`

Then this plugin can be implemented by appending your `build.gradle` with this

```
buildscript {
    repositories {
        maven {
            url = uri("$buildDir/repo")
        }
    }
    dependencies {
        classpath("com.tejasm.gradle:GradleText:1.0.0")
    }
}
apply(plugin = "com.tejasm.gradle.gradletext")
```
