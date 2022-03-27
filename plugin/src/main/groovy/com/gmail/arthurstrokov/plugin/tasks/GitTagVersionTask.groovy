package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.utils.HelpfulGitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GitTagVersionTask extends DefaultTask {

    @TaskAction
    def gitTagVersion() {
        def tags = HelpfulGitUtil.getGitTags()
        if (tags.isEmpty()) {
            HelpfulGitUtil.createTag("v0.0")
        }
        def tagsArray = tags.replace("v", "").split("\n")
        def floatTagsArray = []
        for (element in tagsArray) {
            floatTagsArray.add(Float.parseFloat(element))
        }
        def floatTagsArraySorted = floatTagsArray.collect { it as Float }.sort { it } // or -it for reverse
        def currentTagVersion = "v" + floatTagsArraySorted[floatTagsArraySorted.size() - 1]
        println("current tag version: $currentTagVersion")
    }
}
