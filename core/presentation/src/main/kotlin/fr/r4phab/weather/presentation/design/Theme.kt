package fr.r4phab.weather.presentation.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun ThemedScreen(
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
){
    ProvideWindowInsets {
        MaterialTheme(
            colors = if (darkMode) Colors.dark else Colors.light,
            content = content,
        )
    }
}