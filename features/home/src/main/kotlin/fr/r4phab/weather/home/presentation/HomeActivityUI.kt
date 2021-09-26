package fr.r4phab.weather.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
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
import fr.r4phab.weather.presentation.design.Texts
import fr.r4phab.weather.presentation.design.ThemedScreen

interface HomeActivityUIListener{
    fun addPlaceClicked()
}

@Composable
fun HomeActivityUI(
    listener: HomeActivityUIListener
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
                        ) },
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
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
            ) {

            }
        }
    }
}