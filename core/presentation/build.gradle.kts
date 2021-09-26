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
    api("com.google.android.material:material:1.4.0")
    api("androidx.appcompat:appcompat:1.3.1")
    api("androidx.activity:activity-compose:1.3.1")
    api("androidx.compose.ui:ui-tooling:1.0.2")
    api("androidx.compose.material:material:${Versions.compose}")
    api("com.google.accompanist:accompanist-insets:0.18.0")

    testImplementation("junit:junit:4.13.1")
}