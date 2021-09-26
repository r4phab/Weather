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
    implementation(project(":core:data"))
    implementation(project(":core:domain"))

    testImplementation("junit:junit:4.13.1")
}