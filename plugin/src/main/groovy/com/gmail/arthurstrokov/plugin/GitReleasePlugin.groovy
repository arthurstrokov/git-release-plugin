package com.gmail.arthurstrokov.plugin

import com.gmail.arthurstrokov.plugin.model.MajorBranch
import com.gmail.arthurstrokov.plugin.service.GitCommandService
import com.gmail.arthurstrokov.plugin.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project

class GitReleasePlugin implements Plugin<Project> {

    void apply(Project project) {
        // Register a task
        project.tasks.register("gitReleasePluginHello") {
            doLast {
                println("Hello from git release plugin")
            }
        }

        project.tasks.register("checkGitVersion", CheckGitVersionTask) {
        }

        project.tasks.register("checkGitStatus", CheckGitStatusTask) {
            dependsOn("checkGitVersion")
        }

        project.tasks.register("checkGitCommitLogStatus", CheckGitCommitLogStatusTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
        }

        project.tasks.register("getPluginMajorBranch") {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
            println "Major plugin branch: " + MajorBranch.majorBranch()
            setDescription("Show major branch name. Default 'master'")
        }

        project.tasks.register("setPluginMajorBranch", PluginBranchTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
            setDescription("Set name for major branch")
        }

        project.tasks.register("updateMajorReleaseTag", MajorReleaseTask) {
            setGroup("git release plugin")
            dependsOn("checkGitCommitLogStatus")
        }

        project.tasks.register("updateMinorReleaseTag", MinorReleaseTask) {
            setGroup("git release plugin")
            dependsOn("checkGitCommitLogStatus")
        }

        project.tasks.register("updateReleaseTag") {
            setGroup("git release plugin")
            def currentBrunch = GitCommandService.checkCurrentBranch()
            if (currentBrunch.contains(MajorBranch.majorBranch())) {
                dependsOn("updateMajorReleaseTag")
            } else {
                dependsOn("updateMinorReleaseTag")
            }
        }
    }
}
