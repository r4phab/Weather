package fr.r4phab.weather.interactors.mappers

import com.soywiz.klock.DateTime
import fr.r4phab.weather.data.entities.OWInformationEntity
import fr.r4phab.weather.data.entities.OWOneCallResponseEntity
import fr.r4phab.weather.domain.models.PositionWeatherModel
import fr.r4phab.weather.domain.models.WeatherForecastModel

fun OWOneCallResponseEntity.asModel() =
    PositionWeatherModel(
        current = daily.first().asModel(),
        forecast = daily
            .drop(1)
            .map {
                it.asModel()
            }
    )

fun OWInformationEntity.asModel() =
    WeatherForecastModel(
        day = DateTime.fromUnix(dt * 1000).dayOfWeek,
        weather = weather.first().asWeatherModel()!!,
        dayNight = weather.first().asDayNightModel(),
        minimumTemperature = temp.min,
        maximumTemperature = temp.max,
    )