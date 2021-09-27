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
    api("org.junit.jupiter:junit-jupiter:${Versions.junit}")
    api("io.mockk:mockk:${Versions.mockk}")
    api( "io.mockk:mockk-agent-api:${Versions.mockk}")
    api( "io.mockk:mockk-agent-jvm:${Versions.mockk}")
    api( "io.insert-koin:koin-test:${Versions.koin}")
    api( "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}")
    api( "com.google.truth:truth:${Versions.truth}")
    api( "com.google.truth.extensions:truth-java8-extension:${Versions.truth}")
}