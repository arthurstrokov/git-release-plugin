package com.gmail.arthurstrokov.plugin

import com.gmail.arthurstrokov.plugin.model.MajorBranch
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

        }
        project.tasks.register("checkGitStatus", GitStatusTask) {
            dependsOn("checkGitVersion")
        }
        project.tasks.register("checkCommitLogStatus", GitCommitLogStatusTask) {
            dependsOn("checkGitStatus")
        }
        project.tasks.register("updateMajorReleaseTag", MajorReleaseTask) {
            setGroup("git tag release plugin tasks")
            dependsOn("checkGitStatus")
            dependsOn("checkCommitLogStatus")
        }
        project.tasks.register("updateMinorReleaseTag", MinorReleaseTask) {
            setGroup("git tag release plugin tasks")
            dependsOn("checkGitStatus")
            dependsOn("checkCommitLogStatus")
        }
        project.tasks.register("updateReleaseTag") {
            setGroup("git tag release plugin tasks")
            def currentBrunch = GitCommandService.currentBranch()
            if (currentBrunch.contains(MajorBranch.majorBranch())) {
                dependsOn("updateMajorReleaseTag")
            } else {
                dependsOn("updateMinorReleaseTag")
            }
        }
        project.tasks.register("getPluginMajorBranch") {
            setGroup("git tag release plugin tasks")
            println MajorBranch.majorBranch()
        }
        project.tasks.register("setPluginMajorBranch", PluginBranchTask) {
            setGroup("git tag release plugin tasks")
        }
    }
}
