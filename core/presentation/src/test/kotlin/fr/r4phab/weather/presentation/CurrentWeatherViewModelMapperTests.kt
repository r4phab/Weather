package fr.r4phab.weather.presentation

import fr.r4phab.weather.testing.BaseTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CurrentWeatherViewModelMapperTests : BaseTest() {

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    fun beforeEach() {
    }

    @Test
    fun `When model is mapped to ViewModel, its day name is printed`() {

    }
}