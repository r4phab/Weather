package fr.r4phab.weather.home.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun HomeActivityUI() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Hello") })
            }
        ) {
        }
    }
}