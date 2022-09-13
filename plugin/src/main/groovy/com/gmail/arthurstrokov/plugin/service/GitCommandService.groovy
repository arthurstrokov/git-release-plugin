package com.gmail.arthurstrokov.plugin.service

import org.gradle.api.GradleScriptException

class GitCommandService {

    static checkGitVersion() {
        return ("git --version").execute().text
    }

    static checkGitStatus() {
        return ("git status").execute().text
    }

    static getGitTags() {
        return ("git tag -l").execute().text
    }

    static createGitTag(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        if (!result.empty) {
            throw new GradleScriptException("Tag was not created", null)
        }
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


    def getProperties() {
        Properties properties = new Properties()
        File propertiesFile = new File('gradle.properties')
        propertiesFile.withInputStream {
            properties.load(it)
        }

        def runtimeString = 'a'
        assert properties."$runtimeString" == '1'
        assert properties.b == '2'
    }
}
