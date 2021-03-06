package com.gmail.arthurstrokov.plugin.service

import org.gradle.api.GradleScriptException

class GitCommandService {

    static gitVersion() {
        return ("git --version").execute().text
    }

    static gitStatusResult() {
        return ("git status").execute().text
    }

    static gitTags() {
        return ("git tag -l").execute().text
    }

    static addNewTag(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        if (!result.empty) {
            throw new GradleScriptException("Tag was not created", null)
        }
    }

    static currentBranch() {
        return ("git branch --show-current").execute().text
    }

    static gitBranches() {
        def branches = ("git branch").execute().text
        return branches
    }

    static setPluginMajorBranch() {
        println("Set plugin major branch: ")
        def branch = System.in.newReader().readLine()
        return branch
    }

    static lastCommitLog() {
        return ("git log -1").execute().text
    }

    static lastTag() {
        return ("git describe --abbrev=0").execute().text
    }
}
