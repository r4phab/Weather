plugins {
    id("com.android.library")
    id("kotlin-android")
    id("common")
    id("di")
}

android {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(project(":core:testing"))

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.7.1")
}