/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package com.gmail.arthurstrokov.plugin

import com.gmail.arthurstrokov.plugin.utils.GitUtil
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A simple 'hello world' plugin.
 */
class TestGradleGitReleasePluginPlugin implements Plugin<Project> {
    void apply(Project project) {
        // Register a task
        project.tasks.register("greeting") {
            setGroup("git release tasks")
            doLast {
                println("Hello from plugin 'com.gmail.arthurstrokov.plugin.greeting'")
            }
        }
        project.tasks.register("checkGitStatus", GitStatus) {
            setGroup("git release tasks")
        }
        project.tasks.register("checkCurrentTagVersion") {
            setGroup("git release tasks")
            GitUtil.currentTagVersion
        }
        project.tasks.register("updateMajorReleaseTag", CreateMajorRelease) {
            setGroup("git release tasks")
            dependsOn("checkGitStatus")
        }
        project.tasks.register("updateMinorReleaseTag", CreateMinorRelease) {
            setGroup("git release tasks")
            dependsOn("checkGitStatus")
        }
        project.tasks.register("updateReleaseTag") {
            setGroup("git release tasks")
            def currentBrunch = GitUtil.currentBranch
            println(currentBrunch)
            if (currentBrunch.contains("master")) {
                dependsOn("updateMajorReleaseTag")
            } else {
                dependsOn("updateMinorReleaseTag")
            }
        }
    }
}
