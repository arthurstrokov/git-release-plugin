package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CheckLastGitTagVersionTask extends DefaultTask {

    @TaskAction
    def checkLastGitTagVersion() {
        def lastGitTagVersion = GitCommandService.lastGitTag()
        println(lastGitTagVersion)
    }
}
