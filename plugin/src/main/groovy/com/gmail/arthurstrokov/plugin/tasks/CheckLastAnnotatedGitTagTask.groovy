package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.09.2022
 */
class CheckLastAnnotatedGitTagTask extends DefaultTask {

    @TaskAction
    def checkLastAnnotatedGitTag() {
        def lastAnnotatedGitTag = GitCommandService.lastAnnotatedGitTag()
        println "Last annotated git tag: " + lastAnnotatedGitTag
    }
}
