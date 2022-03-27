package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.model.MajorBranchClass
import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PluginBranchTask extends DefaultTask {

    @TaskAction
    def setMajorBranch() {
        def branches = GitCommandService.gitBranches()
        print(branches)
        def majorBranch = GitCommandService.setPluginMajorBranch()
        MajorBranchClass.majorBranch(majorBranch)
        return majorBranch
    }
}
