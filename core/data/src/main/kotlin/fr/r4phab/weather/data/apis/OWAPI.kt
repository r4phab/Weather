package fr.r4phab.weather.data.apis

import fr.r4phab.weather.data.entities.OWOneCallResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface OWAPI {

    val apiKey get() = "2739ea1fda87a4ad1ac1929bba14d19a"

    @GET("onecall")
    suspend fun oneCall(
        @Query("lat") lat: Double,
        @Query("lon") lng: Double,
        @Query("appid") apiKey: String,
    ): OWOneCallResponseEntity
}