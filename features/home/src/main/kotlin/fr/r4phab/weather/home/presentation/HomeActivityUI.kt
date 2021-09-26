package fr.r4phab.weather.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsHeight
import fr.r4phab.weather.home.R
import fr.r4phab.weather.presentation.design.Margins
import fr.r4phab.weather.presentation.design.Texts
import fr.r4phab.weather.presentation.design.ThemedScreen
import fr.r4phab.weather.presentation.ui.SectionTitleUI
import fr.r4phab.weather.presentation.ui.WeatherForecastDayViewModel
import fr.r4phab.weather.presentation.ui.WeatherForecastUI
import fr.r4phab.weather.presentation.ui.WeatherForecastViewModel

interface HomeActivityUIListener {
    fun addPlaceClicked()
}

@Composable
fun HomeActivityUI(
    listener: HomeActivityUIListener,
) {
    ThemedScreen {
        Scaffold(
            topBar = {
                Column(
                    modifier = Modifier.background(MaterialTheme.colors.primarySurface)
                ) {
                    Spacer(Modifier.statusBarsHeight())
                    TopAppBar(
                        title = {
                            Text(
                                text = "Hello",
                                style = Texts.toolbar()
                            )
                        })
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    modifier = Modifier.navigationBarsPadding(),
                    text = {
                        Text(
                            text = stringResource(id = R.string.action_add_place),
                            style = MaterialTheme.typography.button.copy(color = Color.White)
                        )
                    },
                    icon = {
                        IconButton(modifier = Modifier.size(24.dp),
                            onClick = { }) {
                            Icon(
                                Icons.Filled.Add,
                                "Add",
                                tint = Color.White
                            )
                        }
                    },
                    onClick = listener::addPlaceClicked
                )
            }
        ) {
            Content(
                listener = listener
            )
        }
    }
}

@Composable
private fun Content(
    listener: HomeActivityUIListener,
) {
    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
    ) {
        SectionTitleUI(
            text = "Forecast"
        )

        WeatherForecastUI(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Margins.medium)
                .padding(bottom = Margins.medium),
            viewModel = WeatherForecastViewModel(
                nextDays = listOf(
                    WeatherForecastDayViewModel(
                        name = "Lundi",
                        icon = R.drawable.ic_icon_clear_sky_day,
                        minimumTemperature = "3°",
                        maximumTemperature = "18°",
                    ),
                    WeatherForecastDayViewModel(
                        name = "Mardi",
                        icon = R.drawable.ic_icon_clear_sky_day,
                        minimumTemperature = "3°",
                        maximumTemperature = "18°",
                    )
                )
            )
        )
    }
}