package com.gmail.arthurstrokov.plugin.utils

import org.gradle.api.GradleScriptException

public class GitUtil {

    public static def MAJOR_BRANCH = "master"

//    public static def getGitTagsResult = ("git tag -l").execute().text

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
        def tags = ("git tag -l").execute().text
        if (tags.isEmpty()) {
            createTag("v0.0")
        }
        def tagsArray = tags.replace("v", "").split("\n")
        def floatTagsArray = []
        for (element in tagsArray) {
            floatTagsArray.add(Float.parseFloat(element))
        }
        def floatTagsArraySorted = floatTagsArray.collect { it as Float }.sort { it } // or -it for reverse
//        println floatTagsArraySorted
        def currentTagVersion = "v" + floatTagsArraySorted[floatTagsArraySorted.size() - 1]
        println("current tag version: $currentTagVersion")
        return currentTagVersion
    }

    public static def getTags = ("git tag").execute().text

    public static def createTag(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        if (!result.isEmpty()) {
            throw new GradleScriptException("Tag was not created", null)
        }
    }

    public static def getLastCommitLog() {
        return ("git log -1").execute().text
    }
}
