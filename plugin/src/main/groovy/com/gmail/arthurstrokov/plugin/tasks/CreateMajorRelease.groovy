package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.utils.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CreateMajorRelease extends DefaultTask {

    @TaskAction
    def createMajorRelease() {
        def getTags = GitUtil.getGitTagsResult
        println("getTags: $getTags")
        def currentTagVersion = GitUtil.currentTagVersion
        println("currentTagVersion: $currentTagVersion")
        def tagVersionDetail = currentTagVersion.split('\\.')
        println "tagVersionDetail: $tagVersionDetail"
        def updateMajorTagVersion = Integer.parseInt(tagVersionDetail[0].replaceAll("[^\\d.]", "")) + 1
        println("updateMajorTagVersion: $updateMajorTagVersion")
        def newTagVersion = String.join(".", updateMajorTagVersion as String, "0")
        println("newTagVersion: $newTagVersion")
        def newMajorTagVersion = "v" + newTagVersion
        println("new tag version $newMajorTagVersion")
        GitUtil.createTag(newMajorTagVersion)
        ("git push origin $newMajorTagVersion").execute()
    }
}