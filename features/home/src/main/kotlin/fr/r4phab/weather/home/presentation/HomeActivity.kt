package fr.r4phab.weather.home.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.chargemap.android.router.Router
import fr.r4phab.weather.navigation.Routes
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
    override fun openCreditScreen() {
        Router
            .of(this)
            .push(Routes.Credits)
    }
}