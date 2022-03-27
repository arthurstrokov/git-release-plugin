package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class GitVersionTask extends DefaultTask {

    @TaskAction
    def gitVersion() {
        def gitVersion = GitCommandService.gitVersion()
        if (gitVersion.contains("git")) {
            logger.info(gitVersion)
        } else {
            throw new GradleScriptException("No git available", null)
        }
    }
}
