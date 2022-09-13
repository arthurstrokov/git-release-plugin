package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckLastAnnotatedGitTagVersionTask extends DefaultTask {

    @TaskAction
    def checkLastAnnotatedGitTagVersion() {
        def gitTags = GitCommandService.getGitTags()
        if (gitTags.empty) {
            throw new GradleScriptException("Tag list is empty. Create tag first. Example: 'v0.0'", null)
        }
        def lastAnnotatedGitTagVersion = GitCommandService.lastAnnotatedGitTag()
        if (lastAnnotatedGitTagVersion.contains("fatal")) {
            println "No annotated tags"
        } else {
            println "Last annotated tag:" + lastAnnotatedGitTagVersion
        }
    }
}
