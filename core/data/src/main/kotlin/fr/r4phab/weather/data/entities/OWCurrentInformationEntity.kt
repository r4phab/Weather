package fr.r4phab.weather.data.entities

import com.squareup.moshi.Json

data class OWCurrentInformationEntity(
    @Json(name = "dt") val dt: Long,
    @Json(name = "speed") val speed: Double,
    @Json(name = "pressure") val pressure: Double,
    @Json(name = "humidity") val humidity: Int,
    @Json(name = "weather") val weather: List<OWWeatherEntity>,
    @Json(name = "temp") val temp: Float,
)