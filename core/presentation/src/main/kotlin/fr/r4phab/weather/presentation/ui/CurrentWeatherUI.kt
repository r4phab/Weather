package fr.r4phab.weather.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import fr.r4phab.weather.presentation.R
import fr.r4phab.weather.presentation.design.Colors
import fr.r4phab.weather.presentation.design.Margins

@Preview
@Composable
private fun CurrentWeatherUIPreview() {
    CurrentWeatherUI(
        modifier = Modifier.fillMaxWidth(),
        viewModel = CurrentWeatherViewModel(
            name = "Lundi",
            icon = R.drawable.ic_icon_clear_sky_day,
            minimumTemperature = "3°",
            maximumTemperature = "18°",
            background = "https://unsplash.com/photos/oSIl84tpYYY/download?force=true&w=1920",
        )
    )
}

data class CurrentWeatherViewModel(
    val background: String,
    val name: String,
    val icon: Int,
    val minimumTemperature: String,
    val maximumTemperature: String,
)

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CurrentWeatherUI(
    modifier: Modifier = Modifier,
    viewModel: CurrentWeatherViewModel
) {
    Card(
        modifier = modifier,
    ) {
        Box {
            Surface(
                color = Color.DarkGray.copy(alpha = 0.6f)
            ){
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    painter = rememberImagePainter(data = viewModel.background,
                        builder = {
                            crossfade(true)
                        }),
                    contentScale = ContentScale.Crop,
                    contentDescription = "background"
                )
            }

            Surface(
                modifier = Modifier
                    .align(Alignment.TopStart),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 16.dp,
                    bottomStart = 0.dp
                ),
                color = Color.DarkGray.copy(alpha = 0.6f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .padding(Margins.medium)
                            .size(40.dp),
                        painter = painterResource(id = viewModel.icon),
                        contentDescription = "icon"
                    )

                    Text(
                        modifier = Modifier
                            .padding(horizontal = Margins.medium),
                        text = viewModel.name,
                        style = MaterialTheme.typography.h6.copy(color = Color.White)
                    )
                }
            }

            Surface(
                modifier = Modifier.align(Alignment.BottomStart),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 16.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                ),
                color = Color.DarkGray.copy(alpha = 0.6f)
            ) {
                Text(
                    modifier = Modifier
                        .padding(Margins.medium),
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Colors.secondaryLight)) {
                            append(viewModel.minimumTemperature)
                        }
                        append(" • ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Colors.secondaryDark
                            )
                        ) {
                            append(viewModel.maximumTemperature)
                        }
                    }
                )
            }
        }

    }
}