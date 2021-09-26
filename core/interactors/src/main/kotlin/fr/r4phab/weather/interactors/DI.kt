package fr.r4phab.weather.interactors

import fr.r4phab.weather.domain.repositories.WeatherRepository
import fr.r4phab.weather.interactors.repositories.ReleaseWeatherRepository
import fr.r4phab.weather.interactors.usecases.GetWeatherForPositionUseCase
import org.koin.dsl.module

internal val di by lazy {
    module {

        single<WeatherRepository> { ReleaseWeatherRepository(get()) }
        single { GetWeatherForPositionUseCase(get()) }
    }
}