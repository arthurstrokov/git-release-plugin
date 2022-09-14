package com.gmail.arthurstrokov.plugin.service

import org.gradle.api.GradleScriptException

class GitCommandService {

    static checkGitVersion() {
        return ("git --version").execute().text
    }

    static checkGitStatus() {
        return ("git status").execute().text
    }

    static gitTags() {
        return ("git tag -l").execute().text
    }

    static gitTagCreate(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        return result
    }

    static gitTagCreate(String version, String commitMessage) {
        def result = ("git tag -a $version -m $commitMessage").execute().text
        return result
    }

    static checkCurrentBranch() {
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

    static lastAnnotatedGitTag() {
        return ("git describe --abbrev=0").execute().text
    }
}
