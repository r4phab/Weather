package fr.r4phab.weather

import fr.r4phab.weather.testing.BaseTest
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomApplicationTests : BaseTest() {

    @BeforeAll
    override fun beforeAll(){
        super.beforeAll()
    }

    @BeforeEach
    fun beforeEach() {

    }

    @Test
    fun `When is application is starting, it should init all modules`() {
        mockkStatic("fr.r4phab.weather.data.InitKt")
        mockkStatic("fr.r4phab.weather.domain.InitKt")
        mockkStatic("fr.r4phab.weather.interactors.InitKt")
        mockkStatic("fr.r4phab.weather.navigation.InitKt")
        mockkStatic("fr.r4phab.weather.presentation.InitKt")

        mockkStatic("fr.r4phab.weather.credits.InitKt")
        mockkStatic("fr.r4phab.weather.home.InitKt")

        verify(exactly = 0) { fr.r4phab.weather.data.init() }
        verify(exactly = 0) { fr.r4phab.weather.domain.init() }
        verify(exactly = 0) { fr.r4phab.weather.interactors.init() }
        verify(exactly = 0) { fr.r4phab.weather.navigation.init() }
        verify(exactly = 0) { fr.r4phab.weather.presentation.init() }

        verify(exactly = 0) { fr.r4phab.weather.credits.init() }
        verify(exactly = 0) { fr.r4phab.weather.home.init() }

        CustomApplication.init(mockk())

        verify(exactly = 1) { fr.r4phab.weather.data.init() }
        verify(exactly = 1) { fr.r4phab.weather.domain.init() }
        verify(exactly = 1) { fr.r4phab.weather.interactors.init() }
        verify(exactly = 1) { fr.r4phab.weather.navigation.init() }
        verify(exactly = 1) { fr.r4phab.weather.presentation.init() }

        verify(exactly = 1) { fr.r4phab.weather.credits.init() }
        verify(exactly = 1) { fr.r4phab.weather.home.init() }
    }
}