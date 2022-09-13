package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckGitVersionTask extends DefaultTask {

    @TaskAction
    def checkGitVersion() {
        def gitVersion = GitCommandService.checkGitVersion()
        if (gitVersion.contains("git")) {
            println gitVersion
        } else {
            throw new GradleScriptException("No git available. Install Git first.", null)
        }
    }
}
