package fr.r4phab.weather.presentation.mappers

import fr.r4phab.weather.domain.models.DayNightModel
import fr.r4phab.weather.domain.models.PositionWeatherModel
import fr.r4phab.weather.domain.models.WeatherForecastModel
import fr.r4phab.weather.domain.models.WeatherModel
import fr.r4phab.weather.presentation.R
import fr.r4phab.weather.presentation.ui.WeatherForecastDayViewModel
import fr.r4phab.weather.presentation.ui.WeatherForecastViewModel
import kotlin.math.roundToInt

fun PositionWeatherModel.asViewModel() =
    WeatherForecastViewModel(
        nextDays = forecast
            .map {
                it.asViewModel()
            }
    )

fun WeatherForecastModel.asViewModel() =
    WeatherForecastDayViewModel(
        name = day.localName.replaceFirstChar { it.titlecase() },
        icon = when (weather) {
            WeatherModel.Sun -> when (dayNight) {
                DayNightModel.Night -> R.drawable.ic_icon_clear_sky_night
                DayNightModel.Day -> R.drawable.ic_icon_clear_sky_day
            }
            WeatherModel.Clouds -> when (dayNight) {
                DayNightModel.Night -> R.drawable.ic_icon_broken_clouds_night
                DayNightModel.Day -> R.drawable.ic_icon_broken_clouds_day
            }
            WeatherModel.Drizzle -> when (dayNight) {
                DayNightModel.Night -> R.drawable.ic_icon_rain_night
                DayNightModel.Day -> R.drawable.ic_icon_rain_day
            }
            WeatherModel.Rain -> when (dayNight) {
                DayNightModel.Night -> R.drawable.ic_icon_shower_rain_night
                DayNightModel.Day -> R.drawable.ic_icon_shower_rain_day
            }
            WeatherModel.Snow -> when (dayNight) {
                DayNightModel.Night -> R.drawable.ic_icon_snow_night
                DayNightModel.Day -> R.drawable.ic_icon_snow_day
            }
            WeatherModel.Thunderstorm -> when (dayNight) {
                DayNightModel.Night -> R.drawable.ic_icon_thunderstorm_night
                DayNightModel.Day -> R.drawable.ic_icon_thunderstorm_day
            }
        },
        minimumTemperature = "${(minimumTemperature - 273.15).roundToInt()}°C",
        maximumTemperature = "${(maximumTemperature - 273.15).roundToInt()}°C",
    )