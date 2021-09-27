package fr.r4phab.weather.presentation.x

import com.soywiz.klock.KlockLocale
import com.soywiz.klock.locale.*
import java.util.*

val klockLocale get() =
    when(Locale.getDefault().language){
        "zh" -> KlockLocale.chinese
        "nl" -> KlockLocale.dutch
        "fr" -> KlockLocale.french
        "de" -> KlockLocale.german
        "it" -> KlockLocale.italian
        "ja" -> KlockLocale.japanese
        "ko" -> KlockLocale.korean
        "no" -> KlockLocale.norwegian
        "pt" -> KlockLocale.portuguese
        "ru" -> KlockLocale.russian
        "es" -> KlockLocale.spanish
        "sv" -> KlockLocale.swedish
        "uk" -> KlockLocale.ukrainian
        else -> KlockLocale.english
    }