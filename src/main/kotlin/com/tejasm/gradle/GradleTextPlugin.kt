package com.tejasm.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.GradleBuild

class GradleTextPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val ext = target.extensions.create("GradleText", GradleTextPluginExtension::class.java)

        target.task("hello").doLast(){
            println("Hello World")
        }
    }
}