package fr.r4phab.weather.data.apis

import fr.r4phab.weather.data.entities.OWOneCallResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface OWAPI {

    @GET("onecall")
    suspend fun oneCall(
        @Query("lat") lat: Double,
        @Query("lon") lng: Double,
        @Query("appid") apiKey: String,
    ): OWOneCallResponseEntity
}