package fr.r4phab.weather.interactors.repositories

import fr.r4phab.weather.data.apis.APIKeys
import fr.r4phab.weather.data.apis.OWAPI
import fr.r4phab.weather.domain.models.PositionModel
import fr.r4phab.weather.domain.models.PositionWeatherModel
import fr.r4phab.weather.domain.repositories.WeatherRepository
import fr.r4phab.weather.interactors.mappers.asModel

class ReleaseWeatherRepository(
    private val owApi: OWAPI,
) : WeatherRepository {

    override suspend fun getWeather(position: PositionModel): PositionWeatherModel {
        return owApi
            .oneCall(
                lat = position.latitude,
                lng = position.longitude,
                apiKey = APIKeys.openWeather
            ).asModel()
    }
}