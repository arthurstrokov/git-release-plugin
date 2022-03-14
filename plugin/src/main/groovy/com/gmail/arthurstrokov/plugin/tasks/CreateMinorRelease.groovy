package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.utils.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CreateMinorRelease extends DefaultTask {

    @TaskAction
    def createMinorRelease() {
        println("Minor ->")
        def currentTagVersion = GitUtil.currentTagVersion
        def tagVersionDetail = currentTagVersion.split('\\.')
        def updateMinorTagVersion = Integer.parseInt(tagVersionDetail[1]) + 1
        def newTagVersion = String.join(".", tagVersionDetail[0], updateMinorTagVersion as String)
        println("new tag version $newTagVersion")
        GitUtil.createTag(newTagVersion)
        ("git push origin $newTagVersion").execute()
    }
}
