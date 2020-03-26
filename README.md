# Gradle SMS Notifications
Ever take a break during a Gradle build, get up to go get some coffee only to return to the disappointment that is a failed build? This plugin notifies you via SMS messaging so you can prepare for the grueling task of debugging and rebuilding.

# Status
Incomplete - Currently undergoing development

# Usage
Currently this plugin publishes to both a local Maven repository as well as the Gradle community plugin repository. I would recommend implementation through the plugins DSL as shown below, however if you wish to compile from scratch, the Gradle task `gradlew publish` will generate the plugin in the local Maven repository located at `/builds/repo`. 

This plugin can easily be implemented by appending the plugins section of your  `build.gradle` with this

```
plugins {
  //..
  id "com.tejasm.gradle.gradletext" version "1.0.0"
}
```
