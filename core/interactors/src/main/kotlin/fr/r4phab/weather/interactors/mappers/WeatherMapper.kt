package fr.r4phab.weather.interactors.mappers

import fr.r4phab.weather.data.entities.OWWeatherEntity
import fr.r4phab.weather.domain.models.DayNightModel
import fr.r4phab.weather.domain.models.WeatherModel

fun OWWeatherEntity.asWeatherModel() =
    when {
        id < 300 -> WeatherModel.Thunderstorm
        id < 400 -> WeatherModel.Drizzle
        id < 500 -> null // Should never happen, but who knows
        id < 600 -> WeatherModel.Rain
        id < 700 -> WeatherModel.Snow
        id == 800L -> WeatherModel.Sun
        id > 800L -> WeatherModel.Clouds
        else -> null
    }

fun OWWeatherEntity.asDayNightModel()=
    when {
        icon.endsWith("n") -> DayNightModel.Night
        else -> DayNightModel.Day
    }