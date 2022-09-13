package com.gmail.arthurstrokov.plugin.service


import org.gradle.api.GradleScriptException

class GitTagVersionService {

    static gitTagVersion() {
        def gitTags = GitCommandService.gitTags()
        if (gitTags.empty) {
            throw new GradleScriptException("Tag list is empty. Create tag first. Example: 'git tag v0.0'", null)
        }
        def tagsArray = gitTags.replace("v", "").split("\n")
        def sortedTagsArray = SortService.sortTags(tagsArray)
        def currentTagVersion = "v" + sortedTagsArray.last()
        return currentTagVersion
    }
}
