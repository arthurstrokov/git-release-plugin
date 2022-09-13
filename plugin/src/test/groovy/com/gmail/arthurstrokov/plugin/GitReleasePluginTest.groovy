package com.gmail.arthurstrokov.plugin

import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test
import spock.lang.Specification

class GitReleasePluginTest extends Specification {

    @Test
    def pluginRegistersTaskTest() {
        given:
        def project = ProjectBuilder.builder().build()
        when:
        project.plugins.apply("io.github.arthurstrokov.gitReleasePlugin")
        then:
        project.tasks.findByName("gitReleasePlugin") != null
    }
}
