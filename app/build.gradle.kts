repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

plugins {
    kotlin("android")
    kotlin("kapt")

    id("com.android.application")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "info.firozansari.rxjava"

        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()

        versionCode = 3
        versionName = "1.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // The following argument makes the Android Test Orchestrator run its
        // "pm clear" command after each test invocation. This command ensures
        // that the app's state is completely cleared between tests.
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
        unitTests.all { it.useJUnitPlatform() }
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    kapt {
        correctErrorTypes = true
    }
    dataBinding {
       enable = true
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // AndroidX
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle)
    implementation(libs.constraintlayout)

    // RxJava
    implementation(libs.rxJava)
    implementation(libs.rxAndroid)

    // Moshi
    implementation(libs.moshi)
    implementation(libs.moshiCodeGen)
    implementation(libs.moshi.adapter)
    implementation(libs.androidx.recyclerview)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
