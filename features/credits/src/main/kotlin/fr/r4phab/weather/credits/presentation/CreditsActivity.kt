package fr.r4phab.weather.credits.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreditsActivity : AppCompatActivity(), CreditsActivityUIListener {

    private val viewModel by viewModel<CreditsActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreditsActivityUI(this)
        }
    }

    override fun onBack() = onBackPressed()
}