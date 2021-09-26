package fr.r4phab.weather.domain.models

data class PositionWeatherModel(
    val forecast: List<WeatherForecastModel>,
)