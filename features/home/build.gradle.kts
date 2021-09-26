plugins {
    id("com.android.library")
    id("kotlin-android")
    id("common")
}

android {
    kotlinOptions.jvmTarget = "1.8"
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:presentation"))

    testImplementation("junit:junit:4.13.1")
}