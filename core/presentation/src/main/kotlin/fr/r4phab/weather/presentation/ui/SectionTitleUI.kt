package fr.r4phab.weather.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import fr.r4phab.weather.presentation.design.Margins

@Preview
@Composable
private fun SectionTitleUIPreview() {
    SectionTitleUI(
        modifier = Modifier.fillMaxWidth(),
        text = "Title",
    )
}

@Composable
fun SectionTitleUI(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier
            .padding(
                top = Margins.larger,
                start = Margins.medium,
                bottom = Margins.medium,
                end = Margins.medium
            ),
        text = text,
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.onSurface)
    )
}