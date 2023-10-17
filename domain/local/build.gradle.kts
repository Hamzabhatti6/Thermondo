@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")

}

android {
    namespace = "com.hamza.local"
    compileSdk = 31

    defaultConfig {
        minSdk = 24

        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.room)
    implementation(libs.androidx.lifecycle.livedata.core.ktx)
    kapt(libs.room.annotation.processor)
    implementation(libs.room.ktx)

    implementation(libs.koin.core)
}