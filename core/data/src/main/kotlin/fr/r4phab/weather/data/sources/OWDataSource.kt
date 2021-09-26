package fr.r4phab.weather.data.sources

import fr.r4phab.weather.data.apis.OWAPI

class OWDataSource(
    private val api: OWAPI,
) {

    suspend fun getWeather(latitude: Double, longitude: Double) =
        api.oneCall(
            lat = latitude,
            lng = longitude,
            apiKey = api.apiKey
        )
}