package fr.r4phab.weather.home

import fr.r4phab.weather.home.presentation.HomeActivityViewModel
import fr.r4phab.weather.interactors.usecases.GetRandomCityUseCase
import fr.r4phab.weather.testing.BaseTest
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertNotEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomeActivityViewModelTests : BaseTest() {

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    lateinit var viewModel : HomeActivityViewModel

    @BeforeEach
    fun beforeEach() {
        viewModel = spyk(
            HomeActivityViewModel(
                getWeatherForPositionUseCase = mockk(),
                getRandomCityUseCase = GetRandomCityUseCase()
            )
        )
    }

    @Test
    fun `When viewModel switch places, its place is updated and weather is reloaded`() {
        verify(exactly = 0) { viewModel.loadWeather() }

        val currentPlace = viewModel.place.value.copy()

        viewModel.switchPlace()

        verify(exactly = 1) { viewModel.loadWeather() }
        assertNotEquals(currentPlace, viewModel.place.value)
    }
}