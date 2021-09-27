package fr.r4phab.weather.presentation

import com.soywiz.klock.DayOfWeek
import com.soywiz.klock.KlockLocale
import com.soywiz.klock.locale.french
import fr.r4phab.weather.domain.models.DayNightModel
import fr.r4phab.weather.domain.models.WeatherForecastModel
import fr.r4phab.weather.domain.models.WeatherModel
import fr.r4phab.weather.presentation.mappers.asCurrentWeatherViewModel
import fr.r4phab.weather.presentation.x.klockLocale
import fr.r4phab.weather.testing.BaseTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
    fun `When model is mapped to ViewModel, its day name is correct`() {
        Locale.setDefault(Locale.FRENCH)
        assertEquals(KlockLocale.french, klockLocale)

        checkDayName(DayOfWeek.Monday, "Lundi")
        checkDayName(DayOfWeek.Tuesday, "Mardi")
        checkDayName(DayOfWeek.Wednesday, "Mercredi")
        checkDayName(DayOfWeek.Thursday, "Jeudi")
        checkDayName(DayOfWeek.Friday, "Vendredi")
        checkDayName(DayOfWeek.Saturday, "Samedi")
        checkDayName(DayOfWeek.Sunday, "Dimanche")

        Locale.setDefault(Locale.ENGLISH)
        assertEquals(KlockLocale.english, klockLocale)

        checkDayName(DayOfWeek.Monday, "Monday")
        checkDayName(DayOfWeek.Tuesday, "Tuesday")
        checkDayName(DayOfWeek.Wednesday, "Wednesday")
        checkDayName(DayOfWeek.Tuesday, "Tuesday")
        checkDayName(DayOfWeek.Friday, "Friday")
        checkDayName(DayOfWeek.Saturday, "Saturday")
        checkDayName(DayOfWeek.Sunday, "Sunday")
    }

    @Test
    fun `When model is mapped to ViewModel, its temperatures are appended with units`() {
        WeatherForecastModel(
            day = DayOfWeek.Sunday,
            weather = WeatherModel.Sun,
            dayNight = DayNightModel.Day,
            minimumTemperature = 2.3,
            maximumTemperature = 4.8,
        ).asCurrentWeatherViewModel()
            .let {
                assertTrue {
                    it.minimumTemperature.endsWith("°C")
                    it.maximumTemperature.endsWith("°C")
                }
            }
    }

    private fun checkDayName(dayOfWeek: DayOfWeek, name: String) {
        val model = WeatherForecastModel(
            day = dayOfWeek,
            weather = WeatherModel.Sun,
            dayNight = DayNightModel.Day,
            minimumTemperature = 2.3,
            maximumTemperature = 4.8,
        )

        assertEquals(name, model.asCurrentWeatherViewModel().name)
    }
}