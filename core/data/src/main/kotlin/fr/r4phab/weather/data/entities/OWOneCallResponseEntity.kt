package fr.r4phab.weather.data.entities

import com.squareup.moshi.Json

data class OWOneCallResponseEntity(
    @Json(name = "current") val current: OWInformationEntity,
    @Json(name = "hourly") val hourly: List<OWInformationEntity>,
    @Json(name = "hourly") val daily: List<OWInformationEntity>,
)