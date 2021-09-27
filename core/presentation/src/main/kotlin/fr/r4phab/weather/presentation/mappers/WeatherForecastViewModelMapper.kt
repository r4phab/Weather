package fr.r4phab.weather.presentation.mappers

import fr.r4phab.weather.domain.models.PositionWeatherModel
import fr.r4phab.weather.domain.models.WeatherForecastModel
import fr.r4phab.weather.presentation.ui.WeatherForecastDayViewModel
import fr.r4phab.weather.presentation.ui.WeatherForecastViewModel

fun PositionWeatherModel.asWeatherForecastViewModel() =
    WeatherForecastViewModel(
        nextDays = forecast
            .map {
                it.asWeatherForecastViewModel()
            }
    )

fun WeatherForecastModel.asWeatherForecastViewModel() =
    asCurrentWeatherViewModel().let {
        WeatherForecastDayViewModel(
            name = it.name,
            icon = it.icon,
            minimumTemperature = it.minimumTemperature,
            maximumTemperature = it.maximumTemperature,
        )
    }