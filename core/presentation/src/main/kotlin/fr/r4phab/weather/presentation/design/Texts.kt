package fr.r4phab.weather.presentation.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Texts {

    @Composable
    fun toolbar() = MaterialTheme.typography.h6
        .copy(
            when (isSystemInDarkTheme()) {
                true -> Colors.primary
                false -> Color.White
            }
        )
}