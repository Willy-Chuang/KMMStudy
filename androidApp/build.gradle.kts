plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")


    implementation("androidx.compose.ui:ui:1.0.0-beta02")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta02")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.0.0-beta02")
    // Material Design
    implementation("androidx.compose.material:material:1.0.0-beta02")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.0-beta02")
    implementation("androidx.compose.material:material-icons-extended:1.0.0-beta02")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.3.0-alpha04")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha03")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta02")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.0.0-beta02")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.0-beta02")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.willychuang.kmmstudy.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta01"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}