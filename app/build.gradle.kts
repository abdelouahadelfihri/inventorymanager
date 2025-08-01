plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.inventorymanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.inventorymanager"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // match your Compose version
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // For Material 3
    implementation("androidx.compose.material3:material3:1.2.0")

    // Core Compose libraries
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.1")

    // For Compose Activity integration
    implementation("androidx.activity:activity-compose:1.7.2")
    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.1")

// Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("com.android.tools.build:gradle:8.3.1") // or latest
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    implementation("androidx.compose.material:material-icons-extended:1.6.0")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.compose.material:material:1.5.1")
    implementation(libs.androidx.core.ktx)
    implementation("com.google.dagger:dagger:2.50")
    implementation("com.google.dagger:hilt-android:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}