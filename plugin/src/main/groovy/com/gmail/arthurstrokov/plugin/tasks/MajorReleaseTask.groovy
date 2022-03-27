package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.utils.HelpfulGitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MajorReleaseTask extends DefaultTask {

    @TaskAction
    def createMajorRelease() {
        def currentTagVersion = HelpfulGitUtil.currentTagVersion
        def tagVersionDetail = currentTagVersion.split('\\.')
        def updateMajorTagVersion = Integer.parseInt(tagVersionDetail[0].replaceAll("[^\\d.]", "")) + 1
        def newTagVersion = String.join(".", updateMajorTagVersion as String, "0")
        def newMajorTagVersion = "v" + newTagVersion
        println("new tag version $newMajorTagVersion")
        HelpfulGitUtil.createTag(newMajorTagVersion)
        ("git push origin $newMajorTagVersion").execute()
    }
}
