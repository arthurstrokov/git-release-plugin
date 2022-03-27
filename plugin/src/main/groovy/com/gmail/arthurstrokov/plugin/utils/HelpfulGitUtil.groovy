package com.gmail.arthurstrokov.plugin.utils

import org.gradle.api.GradleScriptException

class HelpfulGitUtil {

    static def getGitVersion() {
        return ("git --version").execute().text
    }

    static def getGitStatusResult() {
        return ("git status").execute().text
    }

    static def getGitTags() {
        return ("git tag -l").execute().text
    }

    static def createTag(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        if (!result.isEmpty()) {
            throw new GradleScriptException("Tag was not created", null)
        }
    }

    static def getCurrentBranch() {
        return ("git branch --show-current").execute().text
    }

    public static final def MAJOR_BRANCH = "master"

    static def getLastCommitLog() {
        return ("git log -1").execute().text
    }
}
