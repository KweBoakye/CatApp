pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    val kotlinVersion: String by settings
    val daggerHiltVersion: String by settings
    plugins {

        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        kotlin("kapt") version kotlinVersion
        id("com.google.dagger.hilt.android") version daggerHiltVersion
        id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:7.3.0")
            }

            when(requested.id.id){
                "dagger.hilt.android.plugin" -> {
                    useModule(
                        "com.google.dagger:hilt-android-gradle-plugin:${requested.version}")

                }
            }
        }
    }
}

enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    val composeUiVersion: String by settings
    val ktorVersion: String by settings
    val kotlinVersion: String by settings
    val daggerHiltVersion: String by settings
    val coilVersion: String by settings
    val lifecycleVersion: String by settings
    val archVersion: String by settings
    versionCatalogs {
        create("libs"){
            val kotlinRef = version("kotlin", kotlinVersion)
            val ktorRef = version("ktor", ktorVersion)
            val composeRef = version("compose", composeUiVersion)
            val hiltRef = version("hilt",daggerHiltVersion)
            val coilRef = version("coil", coilVersion)
            val lifecycleRef = version("lifecycle", lifecycleVersion)
            alias("ktor-client-core").to("io.ktor", "ktor-client-core").versionRef(ktorRef)
            alias("ktor-client-json").to("io.ktor", "ktor-client-json").versionRef(ktorRef)
            alias("ktor-client-serialization").to("io.ktor", "ktor-client-serialization").versionRef(ktorRef)
            alias("ktor-client-okhttp").to("io.ktor", "ktor-client-okhttp").versionRef(ktorRef)
            alias("ktor-client-negotiation").to("io.ktor", "ktor-client-content-negotiation").versionRef(ktorRef)
            alias("ktor-client-logging").to("io.ktor", "ktor-client-logging").versionRef(ktorRef)
            alias("ktor-serialization-kotlinx-json").to("io.ktor", "ktor-serialization-kotlinx-json").versionRef(ktorRef)
            alias("andriodx-compose-ui").to("androidx.compose.ui","ui").versionRef(composeRef)
            alias("andriodx-compose-ui-tooling-preview").to("androidx.compose.ui","ui-tooling-preview").versionRef(composeRef)
            alias("andriodx-compose-ui-test-junit4").to("androidx.compose.ui","ui-test-junit4").versionRef(composeRef)
            alias("andriodx-compose-ui-tooling").to("androidx.compose.ui","ui-tooling").versionRef(composeRef)
            alias("andriodx-compose-ui-test-manifest").to("androidx.compose.ui","ui-test-manifest").versionRef(composeRef)
            alias("runtime-livedata").to("androidx.compose.runtime","runtime-livedata").versionRef(composeRef)
            alias ("hilt").to("com.google.dagger","hilt-android").versionRef(hiltRef)
            alias("hilt-kapt").to("com.google.dagger","hilt-compiler").versionRef(hiltRef)
            alias("coil-core").to("io.coil-kt","coil").versionRef(coilRef)
            alias("coil-compose").to("io.coil-kt","coil-compose").versionRef(coilRef)
            alias("coil-gif").to("io.coil-kt","coil-gif").versionRef(coilRef)
            alias("lifecycle-viewmodel-ktx").to("androidx.lifecycle","lifecycle-viewmodel-ktx").versionRef(lifecycleRef)
            alias("lifecycle-viewmodel-compose").to("androidx.lifecycle","lifecycle-viewmodel-compose").versionRef(lifecycleRef)
            alias("lifecycle-livedata").to("androidx.lifecycle","lifecycle-livedata-ktx").versionRef(lifecycleRef)
            alias("lifecycle-viewmodel-savedstate").to("androidx.lifecycle","lifecycle-viewmodel-savedstate").versionRef(lifecycleRef)
            alias("lifecycle-compiler").to("androidx.lifecycle","lifecycle-compiler").versionRef(lifecycleRef)
            bundle("ktor", listOf("ktor-client-core",
                    "ktor-client-json",
                    "ktor-client-serialization",
                "ktor-client-okhttp",
                "ktor-client-negotiation",
                "ktor-serialization-kotlinx-json",
                "ktor-client-logging"
                )
            )
            bundle("androidx-compose", listOf("andriodx-compose-ui",
                "andriodx-compose-ui-tooling-preview",
            ))
            bundle("compose-debug-test",
            listOf("andriodx-compose-ui-tooling",
                "andriodx-compose-ui-test-manifest",))
            bundle("coil",
                listOf("coil-core", "coil-compose","coil-gif")
                )
            bundle("lifecycle",
            listOf("lifecycle-viewmodel-ktx",
                   "lifecycle-viewmodel-compose",
                "lifecycle-livedata",
                "lifecycle-viewmodel-savedstate",
                "runtime-livedata"
                ))
        }
    }
}
rootProject.name = "CatApp"
include(":app")
