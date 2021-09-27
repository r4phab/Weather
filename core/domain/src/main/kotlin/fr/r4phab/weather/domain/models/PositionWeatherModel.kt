package fr.r4phab.weather.domain.models

data class PositionWeatherModel(
    val current: WeatherForecastModel,
    val forecast: List<WeatherForecastModel>,
)