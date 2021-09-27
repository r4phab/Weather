package fr.r4phab.weather.credits.navigation

import android.content.Intent
import fr.r4phab.weather.credits.presentation.CreditsActivity
import fr.r4phab.weather.navigation.Routes

fun provideNavigation(){
    Routes.Credits.register {
        Intent(it, CreditsActivity::class.java)
    }
}