package com.gmail.arthurstrokov.plugin.service

import com.gmail.arthurstrokov.plugin.util.VersionNumberComparator
import org.gradle.api.GradleScriptException

class GitTagVersionService {

    static gitTagVersion() {
        def gitTags = GitCommandService.getGitTags()
        if (gitTags.empty) {
            throw new GradleScriptException("Tag list is empty. Create tag first. Example: 'git tag v0.0'", null)
        }
        def tagsArray = gitTags.replace("v", "").split("\n")
        def sortedTagsArray = sortTags(tagsArray)
        def currentTagVersion = "v" + sortedTagsArray.last()
        return currentTagVersion
    }

    private static List<String> sortTags(String[] strings) {
        Arrays.sort(strings, new VersionNumberComparator())
        return Arrays.asList(strings)
    }
}
