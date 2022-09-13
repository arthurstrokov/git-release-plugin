package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.model.MajorBranch
import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PluginBranchTask extends DefaultTask {

    @TaskAction
    def setMajorBranch() {
        def branches = GitCommandService.gitBranches()
        print(branches)
        def majorBranch = GitCommandService.setPluginMajorBranch()
        if (majorBranch.empty) {
            MajorBranch.setMajorBranch("master")
        } else {
            MajorBranch.setMajorBranch(majorBranch)
        }
        return majorBranch
    }
}
