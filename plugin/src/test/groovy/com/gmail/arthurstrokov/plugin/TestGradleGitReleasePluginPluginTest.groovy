package com.gmail.arthurstrokov.plugin

import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test
import spock.lang.Specification

class TestGradleGitReleasePluginPluginTest extends Specification {

    @Test
    def pluginRegistersTaskTest() {
        given:
        def project = ProjectBuilder.builder().build()
        when:
        project.plugins.apply("com.gmail.arthurstrokov.plugin.testGradleGitReleasePlugin")
        then:
        project.tasks.findByName("testGradleGitReleasePlugin") != null
    }
}
