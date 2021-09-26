plugins {
    id("com.android.library")
    id("kotlin-android")
    id("common")
    id("di")
}

android {
    kotlinOptions.jvmTarget = "1.8"
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(":core:domain"))

    api("com.google.android.material:material:1.4.0")
    api("androidx.appcompat:appcompat:1.3.1")
    api("androidx.activity:activity-compose:1.3.1")
    api("androidx.compose.ui:ui-tooling:1.0.2")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha03")
    api("androidx.compose.material:material:${Versions.compose}")
    api("com.google.accompanist:accompanist-insets:${Versions.accompanist}")

    testImplementation("junit:junit:4.13.1")
}