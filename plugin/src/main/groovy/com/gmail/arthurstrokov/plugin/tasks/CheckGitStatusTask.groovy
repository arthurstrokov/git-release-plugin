package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckGitStatusTask extends DefaultTask {

    @TaskAction
    def checkGitStatus() {
        def gitStatus = GitCommandService.checkGitStatus()
        if (gitStatus.empty) {
            throw new GradleScriptException("Link to git does not exists", null)
        } else if (gitStatus.contains("new file") || gitStatus.contains("modified")) {
            throw new GradleScriptException("Uncommitted changes was found", null)
        } else {
            println gitStatus
        }
    }
}
