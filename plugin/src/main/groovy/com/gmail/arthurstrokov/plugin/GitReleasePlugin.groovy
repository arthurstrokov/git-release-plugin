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
        project.tasks.register("checkGitVersion", GitVersionTask) {
            setGroup("git release plugin")
        }
        project.tasks.register("getLastGitTagVersion", GitTagVersionTask) {
            setGroup("git release plugin")
        }
        project.tasks.register("checkGitStatus", GitStatusTask) {
            setGroup("git release plugin")
            dependsOn("checkGitVersion")
        }
        project.tasks.register("checkCommitLogStatus", GitCommitLogStatusTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
        }
        project.tasks.register("updateMajorReleaseTag", MajorReleaseTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
            dependsOn("checkCommitLogStatus")
        }
        project.tasks.register("updateMinorReleaseTag", MinorReleaseTask) {
            setGroup("git release plugin")
            dependsOn("checkGitStatus")
            dependsOn("checkCommitLogStatus")
        }
        project.tasks.register("updateReleaseTag") {
            setGroup("git release plugin")
            def currentBrunch = GitCommandService.currentBranch()
            if (currentBrunch.contains(MajorBranch.majorBranch())) {
                dependsOn("updateMajorReleaseTag")
            } else {
                dependsOn("updateMinorReleaseTag")
            }
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
