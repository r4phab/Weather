package fr.r4phab.weather.home.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class HomeActivity  : AppCompatActivity(), HomeActivityUIListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeActivityUI(this)
        }
    }

    override fun addPlaceClicked() {

    }
}