package fr.r4phab.weather.data.entities

import com.squareup.moshi.Json

data class OWWeatherEntity(
    @Json(name = "id") val id: Long,
    @Json(name = "icon") val icon: String,
)