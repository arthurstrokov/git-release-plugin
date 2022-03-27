package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.utils.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class GitVersionTask extends DefaultTask {

    @TaskAction
    def gitVersion() {
        def gitVersion = GitUtil.gitVersion
        if (!gitVersion.contains("git")) {
            throw new GradleScriptException("No git available", null)
        } else {
            println(gitVersion)
        }
    }
}
