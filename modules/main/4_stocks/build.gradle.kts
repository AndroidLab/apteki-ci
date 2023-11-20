@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.apteka.library.convention.plugin.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.apteka.hilt.convention.plugin.get().pluginId)
    id(libs.plugins.apteka.navigation.convention.plugin.get().pluginId)
    id(libs.plugins.apteka.retrofit.convention.plugin.get().pluginId)
    id(libs.plugins.apteka.room.convention.plugin.get().pluginId)
    id(libs.plugins.apteka.glide.convention.plugin.get().pluginId)
}

android {
    namespace = "ru.apteka.stocks"
}

dependencies {
    implementation(project(":components"))
    implementation(project(":modules:main:main_common"))
    implementation(project(":modules:features:product_card:api"))

    implementation(libs.bundles.navigationDeps)
}