## test-gradle-git-release-plugin

#### 1. Delete All local tags. (Optional Recommended)

    git tag -d $(git tag -l)

#### 2. Fetch remote All tags. (Optional Recommended)

    git fetch

#### 3. Delete All remote tags.

    git push origin --delete $(git tag -l) # Pushing once should be faster than multiple times

#### 4. Delete All local tags.

    git tag -d $(git tag -l)
