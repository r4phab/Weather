package fr.r4phab.weather.data.entities

import com.squareup.moshi.Json

data class OWOneCallResponseEntity(
    @Json(name = "current") val current: OWCurrentInformationEntity,
    @Json(name = "hourly") val hourly: List<OWCurrentInformationEntity>,
    @Json(name = "daily") val daily: List<OWInformationEntity>,
)