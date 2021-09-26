package fr.r4phab.weather.presentation.errors

import android.content.Context
import fr.r4phab.weather.presentation.R

fun Throwable.errorString(context: Context) =
    when(this){
        else -> context.getString(R.string.error_unknown)
    }