package fr.r4phab.weather.interactors.usecases

import fr.r4phab.weather.domain.models.PositionModel
import fr.r4phab.weather.domain.models.PositionWeatherModel
import fr.r4phab.weather.domain.repositories.WeatherRepository

class GetWeatherForPositionUseCase(
    private val weatherRepository: WeatherRepository,
){
    suspend operator fun invoke(position: PositionModel) : PositionWeatherModel {
        return weatherRepository.getWeather(position = position)
    }
}