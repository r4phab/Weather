package fr.r4phab.weather.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.r4phab.weather.presentation.R
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
private fun WeatherForecastUIPreview(){
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
        LazyColumn(
            modifier = Modifier.padding(Margins.medium)
        ) {
            items(viewModel.nextDays){
                WeatherForecastDayUI(
                    modifier = Modifier
                        .padding(Margins.small)
                        .fillMaxWidth(),
                    viewModel = it
                )
            }
        }
    }
}

@Composable
private fun WeatherForecastDayUI(
    modifier: Modifier = Modifier,
    viewModel : WeatherForecastDayViewModel,
){
    Row(
        modifier = modifier
    ) {
        Text(
            text = viewModel.name,
            style = MaterialTheme.typography.h5.copy(color = Color.White)
        )
    }
}