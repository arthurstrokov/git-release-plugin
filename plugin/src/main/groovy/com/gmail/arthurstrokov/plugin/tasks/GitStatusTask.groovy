package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.utils.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class GitStatusTask extends DefaultTask {

    @TaskAction
    def checkGitStatus() {
        def gitStatusResult = GitUtil.gitStatusResult
        if (gitStatusResult.isEmpty()) {
            throw new GradleScriptException("Link to git does not exists", null)
        } else if (gitStatusResult.contains("new file") || gitStatusResult.contains("modified")) {
            throw new GradleScriptException("Uncommitted changes was found", null)
        } else {
            print(gitStatusResult)
        }
    }
}
