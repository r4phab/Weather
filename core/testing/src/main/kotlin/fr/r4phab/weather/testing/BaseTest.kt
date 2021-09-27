package fr.r4phab.weather.testing

import android.app.Application
import android.util.Log
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic

open class BaseTest {

    val mockApplication by lazy { mockk<Application>() }

    open fun beforeAll(){
        mockApp()
        mockLogs()
    }

    private fun mockApp(){
        every { mockApplication.applicationContext } returns mockApplication
    }

    fun mockLogs() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } answers {
            println("DEBUG: " + firstArg() + ": " + secondArg())
            0
        }
        every { Log.d(any(), any()) } answers {
            println("INFO: " + firstArg() + ": " + secondArg())
            0
        }
        every { Log.i(any(), any()) } answers {
            println("INFO: " + firstArg() + ": " + secondArg())
            0
        }
        every { Log.w(any(), any<String>()) } answers {
            println("WARNING: " + firstArg() + ": " + secondArg())
            0
        }
        every { Log.e(any(), any()) } answers {
            println("ERROR: " + firstArg() + ": " + secondArg())
            0
        }
    }
}