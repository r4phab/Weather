package fr.r4phab.weather.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.r4phab.weather.presentation.R
import fr.r4phab.weather.presentation.design.Colors
import fr.r4phab.weather.presentation.design.Margins

data class WeatherForecastViewModel(
    val nextDays: List<WeatherForecastDayViewModel>
)

data class WeatherForecastDayViewModel(
    val name: String,
    val icon: Int,
    val minimumTemperature: String,
    val maximumTemperature: String,
)

@Preview
@Composable
private fun WeatherForecastUIPreview() {
    WeatherForecastUI(
        modifier = Modifier.fillMaxWidth(),
        viewModel = WeatherForecastViewModel(
            nextDays = listOf(
                WeatherForecastDayViewModel(
                    name = "Lundi",
                    icon = R.drawable.ic_icon_clear_sky_day,
                    minimumTemperature = "3°",
                    maximumTemperature = "18°",
                )
            )
        )
    )
}

@Composable
fun WeatherForecastUI(
    modifier: Modifier = Modifier,
    viewModel: WeatherForecastViewModel
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
        ) {
            viewModel.nextDays.forEachIndexed { i, it ->
                WeatherForecastDayUI(
                    modifier = Modifier
                        .padding(horizontal = Margins.medium)
                        .padding(
                            top = when (i) {
                                0 -> Margins.medium
                                else -> Margins.small
                            },
                            bottom = Margins.medium
                        )
                        .fillMaxWidth(),
                    viewModel = it
                )

                if (i < viewModel.nextDays.size - 1) {
                    Divider()
                }
            }
        }
    }
}

@Composable
private fun WeatherForecastDayUI(
    modifier: Modifier = Modifier,
    viewModel: WeatherForecastDayViewModel,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = viewModel.icon),
            contentDescription = "icon"
        )

        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = Margins.medium),
            text = viewModel.name,
            style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.onSurface)
        )

        Row(
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Colors.secondaryLight)) {
                        append(viewModel.minimumTemperature)
                    }
                    append(" • ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Colors.secondaryDark)) {
                        append(viewModel.maximumTemperature)
                    }
                }
            )
        }
    }
}