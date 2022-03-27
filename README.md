# test-gradle-git-release-plugin

Delete All local tags. (Optional Recommended)

    git tag -d $(git tag -l)

Fetch remote All tags. (Optional Recommended)

    git fetch

Delete All remote tags.

    git push origin --delete $(git tag -l) # Pushing once should be faster than multiple times

Delete All local tags.

    git tag -d $(git tag -l)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/fb83edd7f3b24a76af346bf72cb970c0)](https://app.codacy.com/gh/arthurstrokov/test-gradle-git-release-plugin?utm_source=github.com&utm_medium=referral&utm_content=arthurstrokov/test-gradle-git-release-plugin&utm_campaign=Badge_Grade_Settings)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/8591306f62ba4b0885efbe3c9f4b1c41)](https://www.codacy.com/gh/arthurstrokov/test-gradle-git-release-plugin/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=arthurstrokov/test-gradle-git-release-plugin&amp;utm_campaign=Badge_Grade)
