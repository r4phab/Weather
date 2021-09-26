package fr.r4phab.weather.interactors.mappers

import com.soywiz.klock.DateTime
import fr.r4phab.weather.data.entities.OWOneCallResponseEntity
import fr.r4phab.weather.domain.models.DayNightModel
import fr.r4phab.weather.domain.models.PositionWeatherModel
import fr.r4phab.weather.domain.models.WeatherForecastModel

fun OWOneCallResponseEntity.asModel() =
    PositionWeatherModel(
        forecast = daily.map {
            WeatherForecastModel(
                day = DateTime.fromUnix(it.dt * 1000).dayOfWeek,
                weather = it.weather.first().asModel()!!,
                dayNight = when {
                    it.weather.first().icon.endsWith("n") -> DayNightModel.Night
                    else -> DayNightModel.Day
                },
                minimumTemperature = it.temp.min,
                maximumTemperature = it.temp.max,
            )
        }
    )