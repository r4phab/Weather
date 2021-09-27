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

    api("com.chargemap.android:router:${Versions.router}")
}