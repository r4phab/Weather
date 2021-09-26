package fr.r4phab.weather.presentation.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
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
                small = RoundedCornerShape(size = 10.dp),
                medium = RoundedCornerShape(size = 20.dp),
                large = RoundedCornerShape(size = 40.dp),
            ),
            content = content,
        )
    }
}