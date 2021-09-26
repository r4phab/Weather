package fr.r4phab.weather.home

import fr.r4phab.weather.home.presentation.HomeActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val di by lazy {
    module {
        viewModel { HomeActivityViewModel(get()) }
    }
}