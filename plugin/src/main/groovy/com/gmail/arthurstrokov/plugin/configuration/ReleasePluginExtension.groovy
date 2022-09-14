package com.gmail.arthurstrokov.plugin.configuration

import org.gradle.api.provider.Property

/**
 * @author Артур Строков
 * @email astrokov@clevertec.ru
 * @created 14.09.2022
 */
interface ReleasePluginExtension {
    abstract Property<String> getReleaseBranch()
}
