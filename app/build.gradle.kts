plugins {
    id("com.android.application")

    id("org.jetbrains.kotlin.android")
    // ... other plugins ...
    //id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.subtask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.subtask"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core libraries
    implementation(libs.androidx.core.ktx) // Android Core KTX for Kotlin extensions
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle runtime KTX
    implementation(libs.androidx.activity.compose) // Activity Compose support

    // Jetpack Compose
    implementation(platform(libs.androidx.compose.bom)) // BOM for Jetpack Compose
    implementation(libs.androidx.ui) // Jetpack Compose UI
    implementation(libs.androidx.ui.graphics) // Jetpack Compose Graphics
    implementation(libs.androidx.ui.tooling.preview) // Preview support for Jetpack Compose
    implementation(libs.androidx.material3) // Material Design 3 components for Jetpack Compose

    // Networking (optional, if you need network requests)
    implementation(libs.retrofit) // Retrofit for network calls
    implementation("androidx.compose.compiler:compiler:1.5.15") // Add the Compose Compiler plugin

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.compose.ui:ui:1.4.3")            // Compose UI
    implementation("androidx.compose.ui:ui-graphics:1.4.3")      // Compose Graphics
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.annotation:annotation:1.5.0")
    implementation("androidx.appcompat:appcompat:1.7.0")

    implementation(libs.androidx.core) // Compose Preview
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")   // Compose Tooling
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3") // Compose Test Manife
    implementation("androidx.compose.material3:material3:1.1.1")
    //implementation("com.example.library:library-name:1.0.0") {
       // exclude(group = "com.conflicting.library", module = "conflicting-module")
    //}
    implementation("androidx.room:room-runtime:2.5.2")
    implementation ("androidx.appcompat:appcompat:1.6.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")



    // Image Loading (optional)
    implementation(libs.coil)
    implementation(libs.androidx.appcompat) // Coil for image loading in Jetpack Compose



    // Testing
    testImplementation(libs.junit) // JUnit for unit testing
    androidTestImplementation(libs.androidx.junit) // JUnit extensions for Android
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom)) // BOM for Compose testing
    androidTestImplementation(libs.androidx.ui.test.junit4) // Jetpack Compose testing
    debugImplementation(libs.androidx.ui.tooling) // Tooling for debugging Jetpack Compose
    debugImplementation(libs.androidx.ui.test.manifest) // Manifest for testing Jetpack Compose
}
