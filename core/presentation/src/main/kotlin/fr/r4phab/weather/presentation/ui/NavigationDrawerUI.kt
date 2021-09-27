package fr.r4phab.weather.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import fr.r4phab.weather.presentation.design.Colors
import fr.r4phab.weather.presentation.design.Margins

data class NavigationDrawerViewModel(
    val logo: Int,
    val copyright: String,
    val items: List<NavigationDrawerItemViewModel>,
)

data class NavigationDrawerItemViewModel(
    val name: String,
    val isSelected: Boolean
)

@OptIn(ExperimentalCoilApi::class)
@Composable
fun NavigationDrawerUI(
    modifier: Modifier = Modifier,
    viewModel: NavigationDrawerViewModel,
    onClick: (Int) -> Unit
) {
    Column {
        Box(
            modifier = modifier
                .background(Colors.primary)
        ){
            Column(
                modifier = modifier
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .padding(vertical = Margins.medium)
            ) {
                // Header
                Image(
                    painter = painterResource(id = viewModel.logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Margins.larger)
                )
            }
        }

        // List of navigation items
        viewModel.items.forEachIndexed { i, it ->
            DrawerItem(
                viewModel = it,
                onClick = {
                    onClick(i)
                }
            )
        }
    }

}

@Composable
private fun DrawerItem(viewModel: NavigationDrawerItemViewModel, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Margins.medium)
            .padding(horizontal = Margins.medium)
            .background(
                when (viewModel.isSelected) {
                    true -> Colors.primary
                    false -> Colors.primaryLight.copy(alpha = 0.5f)
                },
                shape = RoundedCornerShape(percent = 10)
            )
            .clickable(onClick = onClick)
            .padding(start = Margins.medium)
    ) {
        Text(
            modifier = Modifier.padding(Margins.medium),
            text = viewModel.name,
            style = MaterialTheme.typography.body1.copy(color = Color.White)
        )
    }
}