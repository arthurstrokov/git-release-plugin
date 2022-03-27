package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.utils.HelpfulGitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CreateMinorRelease extends DefaultTask {

    @TaskAction
    def createMinorRelease() {
        def currentTagVersion = HelpfulGitUtil.currentTagVersion
        def tagVersionDetail = currentTagVersion.split('\\.')
        def updateMinorTagVersion = Integer.parseInt(tagVersionDetail[1]) + 1
        def newTagVersion = String.join(".", tagVersionDetail[0], updateMinorTagVersion as String)
        println("new tag version $newTagVersion")
        HelpfulGitUtil.createTag(newTagVersion)
        ("git push origin $newTagVersion").execute()
    }
}
