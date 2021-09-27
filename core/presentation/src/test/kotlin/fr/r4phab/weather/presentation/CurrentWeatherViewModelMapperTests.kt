package fr.r4phab.weather.presentation

import fr.r4phab.weather.data.entities.OWWeatherEntity
import fr.r4phab.weather.domain.models.DayNightModel
import fr.r4phab.weather.domain.models.WeatherModel
import fr.r4phab.weather.interactors.mappers.asDayNightModel
import fr.r4phab.weather.interactors.mappers.asWeatherModel
import fr.r4phab.weather.testing.BaseTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

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

    private fun checkIconWithModel(icon: String, expectedModel: DayNightModel) {
        val entity = OWWeatherEntity(id = 2, icon = icon)
        assertEquals(expectedModel, entity.asDayNightModel())
    }
}