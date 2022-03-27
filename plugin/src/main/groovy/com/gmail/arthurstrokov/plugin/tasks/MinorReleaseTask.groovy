package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitCommandService
import com.gmail.arthurstrokov.plugin.service.GitTagVersionService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MinorReleaseTask extends DefaultTask {

    @TaskAction
    def minorRelease() {
        def currentTagVersion = GitTagVersionService.gitTagVersion()
        def tagVersionDetail = currentTagVersion.split('\\.')
        def updateMinorTagVersion = Float.parseFloat(tagVersionDetail[1]) + 1
        def newTagVersion = String.join(".", tagVersionDetail[0], updateMinorTagVersion as String)
        GitCommandService.addNewTag(newTagVersion)
        ("git push origin $newTagVersion").execute()
        logger.info(newTagVersion)
        println(newTagVersion)
    }
}
