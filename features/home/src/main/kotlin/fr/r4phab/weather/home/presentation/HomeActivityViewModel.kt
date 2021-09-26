package fr.r4phab.weather.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.r4phab.weather.domain.models.PlaceModel
import fr.r4phab.weather.domain.models.PositionModel
import fr.r4phab.weather.domain.models.PositionWeatherModel
import fr.r4phab.weather.interactors.usecases.GetWeatherForPositionUseCase
import fr.r4phab.weather.presentation.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeActivityViewModel(
    private val getWeatherForPositionUseCase: GetWeatherForPositionUseCase,
) : ViewModel() {

    val place = MutableStateFlow(
        PlaceModel(
            "Vosges",
            PositionModel(48.86673873744976, 2.342913274243554)
        )
    )

    val weatherResource = MutableStateFlow<Resource<PositionWeatherModel>>(Resource.Nothing())

    fun loadWeather() {
        viewModelScope.launch {
            weatherResource.value = Resource.Loading()
            try{
                getWeatherForPositionUseCase(place.value.position)
                    .apply {
                        weatherResource.value = Resource.Success(this)
                    }
            }catch (e: Throwable){
                e.printStackTrace()
                weatherResource.value = Resource.Error(e)
            }
        }
    }
}