package fr.r4phab.weather.credits

import fr.r4phab.weather.credits.navigation.provideNavigation
import org.koin.core.context.loadKoinModules

fun init(){
    loadKoinModules(di)
    provideNavigation()
}