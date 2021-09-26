plugins {
    id("com.android.application")
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
    api("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

    implementation(project(":features:home"))

    testImplementation("junit:junit:4.13.1")
}