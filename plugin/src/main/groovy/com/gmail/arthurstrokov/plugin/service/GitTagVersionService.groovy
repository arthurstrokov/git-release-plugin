package com.gmail.arthurstrokov.plugin.service

import org.gradle.api.GradleScriptException

class GitTagVersionService {

    static gitTagVersion() {
        def gitTags = GitCommandService.gitTags()
        if (gitTags.empty) {
            throw new GradleScriptException("Tag list was empty. Create tag with 'v0.0' style", null)
        }
        def tagsArray = gitTags.replace("v", "").split("\n")
        def sortedTagsArray = SortService.sort(tagsArray)
        def currentTagVersion = "v" + sortedTagsArray.last()
        return currentTagVersion
    }
}
