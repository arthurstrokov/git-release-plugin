package com.gmail.arthurstrokov.plugin

import com.gmail.arthurstrokov.plugin.utils.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class GitStatus extends DefaultTask {

    @TaskAction
    def checkGitStatus() {
        def gitVersion = GitUtil.gitVersion
        if (!gitVersion.contains("git")) {
            throw new GradleScriptException("No git", null)
        }
        def statusResult = GitUtil.gitStatusResult
        if (statusResult.isEmpty()) {
            throw new GradleScriptException("Link to git does not exists", null)
        } else if (statusResult.contains("new file") || statusResult.contains("modified")) {
            throw new GradleScriptException("Uncommitted changes was found", null)
        }
    }
}
