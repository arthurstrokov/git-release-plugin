package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import com.gmail.arthurstrokov.plugin.service.GitTagVersionService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MajorReleaseTask extends DefaultTask {

    @TaskAction
    def majorRelease() {
        def currentTagVersion = GitTagVersionService.gitTagVersion()
        def tagVersionDetail = currentTagVersion.split('\\.')
        def updateMajorTagVersion = Integer.parseInt(tagVersionDetail[0].replaceAll("[^\\d.]", "")) + 1
        def newTagVersion = String.join(".", updateMajorTagVersion as String, "0")
        def newMajorTagVersion = "v" + newTagVersion
        GitCommandService.addNewTag(newMajorTagVersion)
        logger.info(newMajorTagVersion)
        println(newMajorTagVersion)
        ("git push origin $newMajorTagVersion").execute()
    }
}
