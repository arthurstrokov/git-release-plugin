# git-release-plugin

Plugin for creating git tag for release control

git tag example: v1.0 where '1' is Major and '0' is Minor versions respectively

'updateMajorReleaseTag' task updates Major by incrementing the value by one regardless of which git branch is current
and push changes to git

'updateMinorReleaseTag' task updates Minor by incrementing the value by one regardless of which git branch is current
and push changes to git

'updateReleaseTag' task updates Major or Minor depending on whether such a branch is considered the main and push
changes to git

Default name of main branch is 'master'

You can set any name for branch which do you consider the main using 'setPluginMajorBranch' task

Also, you can check name for main branch using 'getPluginMajorBranch' task

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b757ffad32634c4ebc15f247f08a8f92)](https://www.codacy.com/gh/arthurstrokov/test-gradle-git-release-plugin/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=arthurstrokov/test-gradle-git-release-plugin&amp;utm_campaign=Badge_Grade)