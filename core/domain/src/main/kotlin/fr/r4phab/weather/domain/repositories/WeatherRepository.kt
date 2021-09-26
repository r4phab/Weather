package fr.r4phab.weather.domain.repositories

import fr.r4phab.weather.domain.models.PositionModel
import fr.r4phab.weather.domain.models.PositionWeatherModel

interface WeatherRepository {
    suspend fun getWeather(position: PositionModel) : PositionWeatherModel
}