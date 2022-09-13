package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckLastGitTagVersionTask extends DefaultTask {

    @TaskAction
    def checkLastGitTagVersion() {
        def gitTags = GitCommandService.getGitTags()
        if (gitTags.empty) {
            throw new GradleScriptException("Tag list is empty. Create tag first. Example: 'v0.0'", null)
        } else {
            def lastGitTagVersion = GitCommandService.lastGitTag()
            println(lastGitTagVersion)
        }
    }
}
