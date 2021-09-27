package fr.r4phab.weather.interactors

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
class WeatherMapperTests : BaseTest() {

    @BeforeAll
    override fun beforeAll(){
        super.beforeAll()
    }

    @BeforeEach
    fun beforeEach() {}

    // See https://openweathermap.org/weather-conditions
    @Test
    fun `When entity is mapped to Model, the weather is well mapped`() {
        checkCodeWithModel(200, WeatherModel.Thunderstorm)
        checkCodeWithModel(201, WeatherModel.Thunderstorm)
        checkCodeWithModel(202, WeatherModel.Thunderstorm)
        checkCodeWithModel(210, WeatherModel.Thunderstorm)
        checkCodeWithModel(211, WeatherModel.Thunderstorm)
        checkCodeWithModel(212, WeatherModel.Thunderstorm)
        checkCodeWithModel(221, WeatherModel.Thunderstorm)
        checkCodeWithModel(230, WeatherModel.Thunderstorm)
        checkCodeWithModel(231, WeatherModel.Thunderstorm)
        checkCodeWithModel(232, WeatherModel.Thunderstorm)

        checkCodeWithModel(300, WeatherModel.Drizzle)
        checkCodeWithModel(301, WeatherModel.Drizzle)
        checkCodeWithModel(302, WeatherModel.Drizzle)
        checkCodeWithModel(310, WeatherModel.Drizzle)
        checkCodeWithModel(311, WeatherModel.Drizzle)
        checkCodeWithModel(312, WeatherModel.Drizzle)
        checkCodeWithModel(313, WeatherModel.Drizzle)
        checkCodeWithModel(314, WeatherModel.Drizzle)
        checkCodeWithModel(321, WeatherModel.Drizzle)

        checkCodeWithModel(500, WeatherModel.Rain)
        checkCodeWithModel(501, WeatherModel.Rain)
        checkCodeWithModel(502, WeatherModel.Rain)
        checkCodeWithModel(503, WeatherModel.Rain)
        checkCodeWithModel(504, WeatherModel.Rain)
        checkCodeWithModel(511, WeatherModel.Rain)
        checkCodeWithModel(520, WeatherModel.Rain)
        checkCodeWithModel(521, WeatherModel.Rain)
        checkCodeWithModel(522, WeatherModel.Rain)
        checkCodeWithModel(531, WeatherModel.Rain)

        checkCodeWithModel(600, WeatherModel.Snow)
        checkCodeWithModel(601, WeatherModel.Snow)
        checkCodeWithModel(602, WeatherModel.Snow)
        checkCodeWithModel(611, WeatherModel.Snow)
        checkCodeWithModel(612, WeatherModel.Snow)
        checkCodeWithModel(613, WeatherModel.Snow)
        checkCodeWithModel(615, WeatherModel.Snow)
        checkCodeWithModel(616, WeatherModel.Snow)
        checkCodeWithModel(620, WeatherModel.Snow)
        checkCodeWithModel(621, WeatherModel.Snow)
        checkCodeWithModel(622, WeatherModel.Snow)

        checkCodeWithModel(800, WeatherModel.Sun)

        checkCodeWithModel(801, WeatherModel.Clouds)
        checkCodeWithModel(802, WeatherModel.Clouds)
        checkCodeWithModel(803, WeatherModel.Clouds)
        checkCodeWithModel(804, WeatherModel.Clouds)
    }

    @Test
    fun `When entity is mapped to Model, the daynight is well mapped`() {
        checkIconWithModel("01d", DayNightModel.Day)
        checkIconWithModel("02d", DayNightModel.Day)
        checkIconWithModel("03d", DayNightModel.Day)
        checkIconWithModel("04d", DayNightModel.Day)
        checkIconWithModel("09d", DayNightModel.Day)
        checkIconWithModel("10d", DayNightModel.Day)
        checkIconWithModel("11d", DayNightModel.Day)
        checkIconWithModel("13d", DayNightModel.Day)
        checkIconWithModel("50d", DayNightModel.Day)

        checkIconWithModel("01n", DayNightModel.Night)
        checkIconWithModel("02n", DayNightModel.Night)
        checkIconWithModel("03n", DayNightModel.Night)
        checkIconWithModel("04n", DayNightModel.Night)
        checkIconWithModel("09n", DayNightModel.Night)
        checkIconWithModel("10n", DayNightModel.Night)
        checkIconWithModel("11n", DayNightModel.Night)
        checkIconWithModel("13n", DayNightModel.Night)
        checkIconWithModel("50n", DayNightModel.Night)
    }

    private fun checkCodeWithModel(code: Long, expectedModel : WeatherModel){
        val entity = OWWeatherEntity(id = code, icon = "10d")
        assertEquals(expectedModel, entity.asWeatherModel())
    }

    private fun checkIconWithModel(icon :String, expectedModel : DayNightModel){
        val entity = OWWeatherEntity(id = 2, icon = icon)
        assertEquals(expectedModel, entity.asDayNightModel())
    }
}