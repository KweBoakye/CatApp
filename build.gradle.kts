// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application")  apply false
    id ("com.android.library")  apply false
    id ("org.jetbrains.kotlin.android")  apply false
    id ("org.jetbrains.kotlin.plugin.serialization") apply false
    id("com.google.dagger.hilt.android") apply false
    kotlin("kapt")  apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") apply false
}

allprojects  {
    repositories {
        google()
        mavenCentral()
    }
}