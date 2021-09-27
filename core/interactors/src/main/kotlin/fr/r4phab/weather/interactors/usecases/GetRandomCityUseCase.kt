package fr.r4phab.weather.interactors.usecases

import fr.r4phab.weather.domain.models.PlaceModel
import fr.r4phab.weather.domain.models.PositionModel

class GetRandomCityUseCase {

    private val places = listOf(
        PlaceModel(
            "Epinal",
            PositionModel(48.86673873744976, 2.342913274243554)
        ),
        PlaceModel(
            "Paris",
            PositionModel(48.85928539558468, 2.3398233696660578)
        ),
        PlaceModel(
            "Bordeaux",
            PositionModel(44.84373884084475, -0.5825808009575247)
        ),
        PlaceModel(
            "Lyon",
            PositionModel(45.76391731731717, 4.820021948804585)
        ),
        PlaceModel(
            "Toulon",
            PositionModel( 43.133477520641556, 5.937558513357981)
        ),
        PlaceModel(
            "Chamonix",
            PositionModel( 45.92472816505762, 6.900249354874261)
        ),
    )

    operator fun invoke(currentPlace: PlaceModel?): PlaceModel {
        return places.toMutableList()
            .apply {
                remove(currentPlace)
            }.random()
    }
}