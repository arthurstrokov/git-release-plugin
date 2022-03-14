## test-gradle-git-release-plugin

#### delete local tags:
    git tag | foreach-object -process { git tag -d $_ }
