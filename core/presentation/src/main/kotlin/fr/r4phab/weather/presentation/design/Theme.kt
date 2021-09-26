package fr.r4phab.weather.presentation.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun ThemedScreen(
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    ProvideWindowInsets {
        MaterialTheme(
            colors = if (darkMode) Colors.dark else Colors.light,
            shapes = Shapes(
                small = RoundedCornerShape(percent = 10),
                medium = RoundedCornerShape(percent = 20),
                large = RoundedCornerShape(percent = 40)
            ),
            content = content,
        )
    }
}