## test-gradle-git-release-plugin

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b56db0b4e9324f5dae207c815ff141d5)](https://app.codacy.com/gh/arthurstrokov/test-gradle-git-release-plugin?utm_source=github.com&utm_medium=referral&utm_content=arthurstrokov/test-gradle-git-release-plugin&utm_campaign=Badge_Grade_Settings)

#### 1. Delete All local tags. (Optional Recommended)

    git tag -d $(git tag -l)

#### 2. Fetch remote All tags. (Optional Recommended)

    git fetch

#### 3. Delete All remote tags.

    git push origin --delete $(git tag -l) # Pushing once should be faster than multiple times

#### 4. Delete All local tags.

    git tag -d $(git tag -l)
