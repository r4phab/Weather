package fr.r4phab.weather.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsHeight
import fr.r4phab.weather.home.R
import fr.r4phab.weather.presentation.Resource
import fr.r4phab.weather.presentation.design.Colors
import fr.r4phab.weather.presentation.design.Margins
import fr.r4phab.weather.presentation.design.Texts
import fr.r4phab.weather.presentation.design.ThemedScreen
import fr.r4phab.weather.presentation.errors.errorString
import fr.r4phab.weather.presentation.mappers.asViewModel
import fr.r4phab.weather.presentation.ui.SectionTitleUI
import fr.r4phab.weather.presentation.ui.WeatherForecastUI
import fr.r4phab.weather.presentation.x.asRememberedState

interface HomeActivityUIListener {
    fun addPlaceClicked()
    fun retryClicked()
}

@Composable
fun HomeActivityUI(
    listener: HomeActivityUIListener,
    viewModel: HomeActivityViewModel,
) {
    val place by viewModel.place.asRememberedState()

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
                                text = place.name,
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
                listener = listener,
                viewModel = viewModel,
            )
        }
    }
}

@Composable
private fun Content(
    listener: HomeActivityUIListener,
    viewModel: HomeActivityViewModel,
) {
    val weather by viewModel.weatherResource.asRememberedState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
    ) {
        when (val it = weather) {
            is Resource.Nothing -> {
            }

            is Resource.Loading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(60.dp)
                            .padding(Margins.larger)
                    )
                }
            }
            is Resource.Error ->
                Snackbar(
                    modifier = Modifier
                        .padding(top = Margins.larger)
                        .padding(horizontal = Margins.medium),
                    backgroundColor = Colors.secondary,
                    action = {
                        Button(onClick = listener::retryClicked) {
                            Text(stringResource(id = R.string.action_retry))
                        }
                    },
                ) {
                    Text(text = it.cause.errorString(LocalContext.current))
                }

            is Resource.Success -> {
                SectionTitleUI(
                    text = "Forecast"
                )

                WeatherForecastUI(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Margins.medium)
                        .padding(bottom = Margins.medium),
                    viewModel = it.value.asViewModel()
                )
            }
        }
    }
}