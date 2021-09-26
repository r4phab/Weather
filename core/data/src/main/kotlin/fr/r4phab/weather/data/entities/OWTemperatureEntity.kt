package fr.r4phab.weather.data.entities

import com.squareup.moshi.Json

data class OWTemperatureEntity(
    @Json(name = "min") val min: Float,
    @Json(name = "max") val max: Float
)