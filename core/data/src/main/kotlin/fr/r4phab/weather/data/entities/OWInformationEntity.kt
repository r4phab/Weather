package fr.r4phab.weather.data.entities

import com.squareup.moshi.Json

data class OWInformationEntity(
    @Json(name = "speed") val speed: Double,
    @Json(name = "pressure") val pressure: Double,
    @Json(name = "humidity") val humidity: Int,
    @Json(name = "weather") val weather: List<OWWeatherEntity>,
)

/*
"dt":1485741600,
         "temp":{
            "day":285.51,
            "min":285.51,
            "max":285.51,
            "night":285.51,
            "eve":285.51,
            "morn":285.51
         },
         "pressure":1013.75,
         "humidity":100,
         "weather":[
            {
               "id":800,
               "main":"Clear",
               "description":"sky is clear",
               "icon":"01n"
            }
         ],
         "speed":5.52,
         "deg":311,
         "gust": 11.3,
         "clouds":0
 */