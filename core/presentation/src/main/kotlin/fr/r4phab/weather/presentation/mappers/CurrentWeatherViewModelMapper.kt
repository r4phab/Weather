package fr.r4phab.weather.presentation.mappers

import fr.r4phab.weather.domain.models.DayNightModel
import fr.r4phab.weather.domain.models.WeatherForecastModel
import fr.r4phab.weather.domain.models.WeatherModel
import fr.r4phab.weather.presentation.R
import fr.r4phab.weather.presentation.ui.CurrentWeatherViewModel
import kotlin.math.roundToInt

fun WeatherForecastModel.asCurrentWeatherViewModel() =
    CurrentWeatherViewModel(
        background = when (weather) {
            WeatherModel.Sun -> when (dayNight) {
                DayNightModel.Night -> "https://unsplash.com/photos/hJNNvvHo3zw/download?force=true&w=1920"
                DayNightModel.Day -> "https://unsplash.com/photos/oSIl84tpYYY/download?force=true&w=1920"
            }
            WeatherModel.Clouds -> when (dayNight) {
                DayNightModel.Night -> "https://unsplash.com/photos/Z4r8t1V2xRg/download?force=true&w=1920"
                DayNightModel.Day -> "https://unsplash.com/photos/P8VMwYFY-Es/download?force=true&w=1920"
            }
            WeatherModel.Drizzle -> when (dayNight) {
                DayNightModel.Night -> "https://unsplash.com/photos/1dNujhlCTYQ/download?force=true&w=1920"
                DayNightModel.Day -> "https://unsplash.com/photos/y8_-hcvH6cc/download?force=true&w=1920"
            }
            WeatherModel.Rain -> when (dayNight) {
                DayNightModel.Night -> "https://unsplash.com/photos/bWtd1ZyEy6w/download?force=true&w=1920"
                DayNightModel.Day -> "https://unsplash.com/photos/FobwhDUgdrk/download?force=true&w=1920"
            }
            WeatherModel.Snow -> when (dayNight) {
                DayNightModel.Night -> "https://unsplash.com/photos/cbOgtT3iLtM/download?force=true&w=1920"
                DayNightModel.Day ->"https://unsplash.com/photos/OlhdrYx8yaQ/download?force=true&w=1920"
            }
            WeatherModel.Thunderstorm -> when (dayNight) {
                DayNightModel.Night -> "https://unsplash.com/photos/dqDgVUgFGTU/download?force=true&w=1920"
                DayNightModel.Day -> "https://unsplash.com/photos/-bSucp2nUdQ/download?force=true&w=1920"
            }
        },
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