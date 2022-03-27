package com.gmail.arthurstrokov.plugin.service

class GitTagVersionService {

    static def gitTagVersion() {
        def gitTags = GitCommandService.getGitTags()
        if (gitTags.empty) {
            GitCommandService.addNewTag("v0.0")
        }
        def tagsArray = gitTags.replace("v", "").split("\n")
        def floatTagsArray = []
        for (element in tagsArray) {
            floatTagsArray.add(Float.parseFloat(element))
        }
        def floatTagsArraySorted = floatTagsArray.collect { it as Float }.sort { it } // or -it for reverse
        def currentTagVersion = "v" + floatTagsArraySorted[floatTagsArraySorted.size() - 1]
        println currentTagVersion
        return currentTagVersion
    }
}
