package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GitTagVersionTask extends DefaultTask {

    @TaskAction
    def tagVersion() {
        def lastTag = GitCommandService.lastTag()
        println(lastTag)
    }
}
