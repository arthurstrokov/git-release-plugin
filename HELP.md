Delete All local tags. (Optional Recommended)

    git tag -d $(git tag -l)

Fetch remote All tags. (Optional Recommended)

    git fetch

Delete All remote tags.

    git push origin --delete $(git tag -l) # Pushing once should be faster than multiple times

When developing a plugin, keep in mind that:

    Git may not be installed on the system
    A plugin can be added to a non-git project
    Across projects, release branches should be configurable
    A task for a major version increment can be called from a non-master branch and vice versa
    The plugin should not create a new git tag if it has already been created based on the last Commit
