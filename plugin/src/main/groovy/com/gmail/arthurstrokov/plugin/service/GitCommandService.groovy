package com.gmail.arthurstrokov.plugin.service

import org.gradle.api.GradleScriptException

class GitCommandService {

    static getGitVersion() {
        return ("git --version").execute().text
    }

    static getGitStatusResult() {
        return ("git status").execute().text
    }

    static getGitTags() {
        return ("git tag -l").execute().text
    }

    static createTag(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        print(result)
        if (!result.isEmpty()) {
            throw new GradleScriptException("Tag was not created", null)
        }
    }

    static getCurrentBranch() {
        return ("git branch --show-current").execute().text
    }

    public static final def MAJOR_BRANCH = "master"

    static getLastCommitLog() {
        return ("git log -1").execute().text
    }
}
