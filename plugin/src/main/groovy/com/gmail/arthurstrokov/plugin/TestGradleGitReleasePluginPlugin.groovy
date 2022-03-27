package com.gmail.arthurstrokov.plugin

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import com.gmail.arthurstrokov.plugin.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestGradleGitReleasePluginPlugin implements Plugin<Project> {

    void apply(Project project) {
        // Register a task
        project.tasks.register("testGradleGitReleasePlugin") {
            doLast {
                println("Hello from plugin")
            }
        }
        project.tasks.register("checkGitVersion", GitVersionTask) {
            setGroup("git tasks")
        }
        project.tasks.register("checkGitStatus", GitStatusTask) {
            setGroup("git tasks")
            dependsOn("checkGitVersion")
        }
        project.tasks.register("checkCommitLogStatus", GitCommitLogStatusTask) {
            setGroup("git tasks")
            dependsOn("checkGitStatus")
        }
        project.tasks.register("updateMajorReleaseTag", MajorReleaseTask) {
            setGroup("git tasks")
            dependsOn("checkGitStatus")
            dependsOn("checkCommitLogStatus")
        }
        project.tasks.register("updateMinorReleaseTag", MinorReleaseTask) {
            setGroup("git tasks")
            dependsOn("checkGitStatus")
            dependsOn("checkCommitLogStatus")
        }
        project.tasks.register("updateReleaseTag") {
            setGroup("git tasks")
            def currentBrunch = GitCommandService.currentBranch()
            if (currentBrunch.contains(MajorBranch.getMajor())) {
                dependsOn("updateMajorReleaseTag")
            } else {
                dependsOn("updateMinorReleaseTag")
            }
        }
        project.tasks.register("getPluginMajorBranch") {
            setGroup("git tasks")
            println MajorBranch.getMajor()
        }
        project.tasks.register("setPluginMajorBranch", PluginBranchTask) {
            setGroup("git tasks")
        }
    }
}
