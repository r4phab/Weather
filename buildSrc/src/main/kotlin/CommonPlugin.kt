import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class CommonPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.findByType(BaseExtension::class.java)?.apply {
            compileSdkVersion(30)
            buildToolsVersion("30.0.2")

            defaultConfig {
                versionCode = 1
                versionName = "0.0.1"
                minSdk = 21
                targetSdk = 30
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables.useSupportLibrary = true
            }

            listOf(
                "debug",
                "test",
                "release",
                "androidTest",
                "main"
            ).forEach {
                sourceSets.getByName(it).java.srcDirs("src/$it/kotlin")
            }

            compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
            compileOptions.targetCompatibility = JavaVersion.VERSION_1_8

            testOptions.unitTests.isReturnDefaultValues = false
        }
    }
}