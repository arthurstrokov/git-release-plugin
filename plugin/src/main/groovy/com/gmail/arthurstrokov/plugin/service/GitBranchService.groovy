package com.gmail.arthurstrokov.plugin.service

import com.gmail.arthurstrokov.plugin.MajorBranch
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GitBranchService extends DefaultTask {

    @TaskAction
    def setMajorBranch() {
        def branches = GitCommandService.gitBranches()
        print(branches)
        def majorBranch = GitCommandService.setMajorBranch()
        MajorBranch.setMajor(majorBranch)
        return majorBranch
    }
}
