package fr.r4phab.weather.home.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), HomeActivityUIListener {

    private val viewModel by viewModel<HomeActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeActivityUI(
                listener = this,
                viewModel = viewModel
            )
        }

        viewModel.loadWeather()
    }

    override fun switchPlaceClicked() = viewModel.switchPlace()
    override fun retryClicked() = viewModel.loadWeather()
}