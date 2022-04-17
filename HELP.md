Delete All local tags. (Optional Recommended)

    git tag -d $(git tag -l)

Fetch remote All tags. (Optional Recommended)

    git fetch

Delete All remote tags.

    git push origin --delete $(git tag -l) # Pushing once should be faster than multiple times

Delete All local tags.

    git tag -d $(git tag -l)
