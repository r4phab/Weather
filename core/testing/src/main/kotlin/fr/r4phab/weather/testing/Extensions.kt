package fr.r4phab.weather.testing

import android.annotation.SuppressLint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runBlockingTest
import java.io.File
import java.nio.file.Paths

@SuppressLint("NewApi")
fun readAsset(name: String) =
    File(
        "${Paths.get("src", "test", "assets").toFile().absolutePath}/$name"
    ).readText(Charsets.UTF_8)

val <T : Any> Flow<T>.resultForTest: T?
    get() {
        var result: T? = null

        runBlockingTest {
            onEach {
                result = it
            }.launchIn(this)
        }

        return result
    }