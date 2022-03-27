package com.gmail.arthurstrokov.plugin.service

class GitTagVersionService {

    static gitTagVersion() {
        def gitTags = GitCommandService.gitTags()
        if (gitTags.empty) {
            GitCommandService.addNewTag("v0.0")
        }
        def tagsArray = gitTags.replace("v", "").split("\n")
        def floatTagsArray = []
        for (element in tagsArray) {
            floatTagsArray.add(Float.parseFloat(element))
        }
        def floatTagsArraySorted = floatTagsArray.collect { it as Float }.sort { it } // or -it for reverse
        def currentTagVersion = "v" + floatTagsArraySorted.last()
        println currentTagVersion
        return currentTagVersion
    }
}
