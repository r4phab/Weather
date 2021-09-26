package fr.r4phab.weather.data

import fr.r4phab.weather.data.apis.OWAPI
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val di by lazy {
    module {

        single<OWAPI>{
            Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(OWAPI::class.java)
        }
    }
}