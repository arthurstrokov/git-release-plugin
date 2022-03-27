package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitTagVersionService
import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class GitCommitLogStatusTask extends DefaultTask {

    @TaskAction
    def checkLastCommitLog() {
        def lastCommittedLogHash = GitCommandService.getLastCommitLog().split("\n")[0].split(" ")[1]
        def lastTagVersion = GitTagVersionService.gitTagVersion()
        def lastTagCommittedLog = ("git show ".concat(lastTagVersion)).execute().text.split("\n")
        def lastTagCommittedLogHash = lastTagCommittedLog[6].split(" ")[1]
        if (lastTagCommittedLogHash == lastCommittedLogHash) {
            throw new GradleScriptException("Tag was created in the last commit", null)
        }
    }
}
