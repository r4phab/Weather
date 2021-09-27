package fr.r4phab.weather.presentation.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Colors {

    val primary = Color(0xFFF76C5E)
    val primaryLight = Color(0xFFF9938A)
    val primaryDark = Color(0xFFF54D3D)

    val secondary = Color(0xFFF68E5F)
    val secondaryLight = Color(0xFFF8AE8B)
    val secondaryDark = Color(0xFFF4783E)

    @Composable
    fun toolbarText() = when(isSystemInDarkTheme()){
        true -> primary
        false -> Color.White
    }

    val dark = darkColors(
        primary = primary,
        primaryVariant = primaryDark,
        secondary = secondary,
        secondaryVariant = secondaryDark,
        onPrimary = Color.White,
        onSecondary = Color.White,
        onBackground = Color.DarkGray,
        onSurface = Color.DarkGray,
        onError = Color.DarkGray
    )

    val light = lightColors(
        primary = primary,
        primaryVariant = primaryDark,
        secondary = secondary,
        secondaryVariant = secondaryDark,
        onPrimary = Color.White,
        onSecondary = Color.White,
        onBackground = Color.DarkGray,
        onSurface = Color.DarkGray,
        onError = Color.DarkGray,
        background = Color.White,
        surface = Color.LightGray,
    )

}