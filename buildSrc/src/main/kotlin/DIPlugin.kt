import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies

class DIPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.findByType(BaseExtension::class.java)?.apply {

        }

        project.dependencies {
            add("implementation", "io.insert-koin:koin-android:${Versions.koin}")
            add("testImplementation", "io.insert-koin:koin-test:${Versions.koin}")
        }
    }
}