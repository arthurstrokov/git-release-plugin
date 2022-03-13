package com.gmail.arthurstrokov.plugin.utils

import org.gradle.api.GradleScriptException

public class GitUtil {

    public static def getGitTagsResult = ("git tag -l").execute().text

    public static def getGitVersion() {
        return ("git --version").execute().text
    }

    public static def getGitStatusResult() {
        return ("git status").execute().text
    }

    public static def getCurrentBranch() {
        return ("git branch --show-current").execute().text
    }

    public static def getCurrentTagVersion() {
        def tags = getGitTagsResult
        if (tags.isEmpty()) {
            throw new GradleScriptException("There is no tags", null)
        }
        def tagsArray = tags.split("\n")
        def currentTagVersion = tagsArray[tagsArray.size() - 1]
        println("current tag version: $currentTagVersion")
        return currentTagVersion
    }

    public static def createTag(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        if (!result.isEmpty()) {
            throw new GradleScriptException("Tag was not created", null)
        }
    }
}
