// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.gradle apply false
    id("com.android.library") version Versions.gradle apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlin apply false
    id("com.android.dynamic-feature") version Versions.gradle apply false
    id("org.jetbrains.kotlin.jvm") version Versions.kotlin apply false
}

buildscript {
    extra["kotlin_version"] = Versions.kotlin

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${JetPackVersion.hilt}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${JetPackVersion.navigation}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}