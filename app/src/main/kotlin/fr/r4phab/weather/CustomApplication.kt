package fr.r4phab.weather

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CustomApplication : Application() {

    companion object{
        fun init(application: Application){
            startKoin {
                androidLogger()
                androidContext(application)
            }

            fr.r4phab.weather.data.init()
            fr.r4phab.weather.domain.init()
            fr.r4phab.weather.navigation.init()
            fr.r4phab.weather.interactors.init()
            fr.r4phab.weather.presentation.init()
            fr.r4phab.weather.home.init()
            fr.r4phab.weather.credits.init()
        }
    }

    override fun onCreate() {
        super.onCreate()
        init(this)
    }
}