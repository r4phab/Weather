package fr.r4phab.weather.credits

import fr.r4phab.weather.credits.presentation.CreditsActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val di by lazy {
    module {
        viewModel { CreditsActivityViewModel() }
    }
}