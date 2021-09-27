package fr.r4phab.weather.credits.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.insets.statusBarsHeight
import fr.r4phab.weather.credits.R
import fr.r4phab.weather.presentation.design.Colors
import fr.r4phab.weather.presentation.design.Margins
import fr.r4phab.weather.presentation.design.Texts
import fr.r4phab.weather.presentation.design.ThemedScreen

interface CreditsActivityUIListener {
    fun onBack()
}

@Composable
fun CreditsActivityUI(
    listener: CreditsActivityUIListener
) {
    ThemedScreen {
        Scaffold(
            topBar = {
                Column(
                    modifier = Modifier.background(MaterialTheme.colors.primarySurface)
                ) {
                    Spacer(Modifier.statusBarsHeight())
                    TopAppBar(
                        navigationIcon = {
                            IconButton(
                                onClick = listener::onBack,
                            ) {
                                Icon(Icons.Filled.ArrowBack, "Search")
                            }
                        },
                        title = {
                            Text(
                                text = "Credits",
                                style = Texts.toolbar()
                            )
                        })
                }
            },
        ) {
            Content()
        }
    }
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState()),
    ) {
        Snackbar(
            modifier = Modifier
                .padding(top = Margins.larger)
                .padding(horizontal = Margins.medium),
            backgroundColor = Colors.secondary,
        ) {
            Text(text = stringResource(id = R.string.copyright))
        }
    }
}