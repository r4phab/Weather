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
    api("com.chargemap.android:router:${Versions.router}")

    testImplementation("junit:junit:4.13.1")
}