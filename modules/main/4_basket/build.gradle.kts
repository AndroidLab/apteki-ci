@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.libraryConventionPlugin.get().pluginId)
    id(libs.plugins.kotlinAndroid.get().pluginId)
    id(libs.plugins.hiltConventionPlugin.get().pluginId)
    id(libs.plugins.navigationConventionPlugin.get().pluginId)
    id(libs.plugins.retrofitConventionPlugin.get().pluginId)
    id(libs.plugins.roomConventionPlugin.get().pluginId)
    id(libs.plugins.glideConventionPlugin.get().pluginId)
}

android {
    namespace = "ru.apteka.basket"
}

dependencies {
    implementation(project(":components"))
    implementation(project(":modules:features:making_order:api"))
    implementation(project(":modules:features:product_card:api"))
    implementation(project(":modules:features:listing:api"))

    implementation(libs.bundles.navigationDeps)
}