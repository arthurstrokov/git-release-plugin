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
            setGroup("git release plugin")
        }

        project.tasks.register("checkGitStatus", CheckGitStatusTask) {
            setGroup("git release plugin")
            dependsOn("checkGitVersion")
        }

        project.tasks.register("checkGitCommitLogStatus", CheckGitCommitLogStatusTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
        }

        project.tasks.register("updateMajorReleaseTag", MajorReleaseTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
            dependsOn("checkGitCommitLogStatus")
        }

        project.tasks.register("updateMinorReleaseTag", MinorReleaseTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
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

        project.tasks.register("checkCurrentBranch", CheckCurrentBranchTask) {
            setGroup("git release plugin")
            setDescription("Show current branch name.")
        }

        project.tasks.register("getPluginMajorBranch") {
            setGroup("git release plugin")
            setDescription("Show major branch name. Default 'master'")
            println MajorBranch.majorBranch()
        }

        project.tasks.register("setPluginMajorBranch", PluginBranchTask) {
            setGroup("git release plugin")
            setDescription("Set name for major branch")
        }
    }
}
