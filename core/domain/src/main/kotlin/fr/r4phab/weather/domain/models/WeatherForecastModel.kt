package fr.r4phab.weather.domain.models

import com.soywiz.klock.DayOfWeek

data class WeatherForecastModel(
    val day: DayOfWeek,
    val weather: WeatherModel,
    val dayNight: DayNightModel,
    val minimumTemperature: Double,
    val maximumTemperature: Double,
)