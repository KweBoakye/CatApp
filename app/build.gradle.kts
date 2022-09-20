import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.kweku.catapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.kweku.catapp"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {


            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =  "1.1.1"
    }
    packagingOptions {
        resources.excludes.add("META-INF/*.kotlin_module")
    }


    hilt {
       enableAggregatingTask = true
    }
}


kapt {
    correctErrorTypes = true
}

dependencies {

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.activity:activity-compose:1.3.1")
    implementation (libs.bundles.androidx.compose)
    implementation ("androidx.compose.material:material:1.1.1")
    implementation (libs.bundles.ktor)
    implementation(libs.hilt)
    kapt(libs.hilt.kapt)
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.jetbrains.kotlin:kotlin-test")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation (libs.andriodx.compose.ui.test.junit4)
    //debugImplementation ("androidx.compose.ui:ui-tooling:$compose_ui_version")
    debugImplementation (libs.bundles.compose.debug.test)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    implementation(libs.bundles.coil)
    implementation(libs.bundles.lifecycle)
    kapt(libs.lifecycle.compiler)
}

