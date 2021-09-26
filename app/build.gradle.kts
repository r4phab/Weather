plugins {
    id("com.android.application")
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
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:navigation"))
    implementation(project(":core:interactors"))
    implementation(project(":core:presentation"))

    implementation(project(":features:home"))

    testImplementation("junit:junit:4.13.1")
}