package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.09.2022
 */
class GitTagVersionTask extends DefaultTask {

    @TaskAction
    def tagVersion() {
        def lastTag = GitCommandService.lastAnnotatedGitTag()
        println(lastTag)
    }
}
