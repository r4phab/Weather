package fr.r4phab.weather.interactors

import fr.r4phab.weather.domain.models.PlaceModel
import fr.r4phab.weather.interactors.usecases.GetRandomCityUseCase
import fr.r4phab.weather.testing.BaseTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertNotEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetRandomCityUseCaseTests : BaseTest() {

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    fun beforeEach() {
    }

    private val currentPlace = GetRandomCityUseCase()(null)

    @Test
    fun `When useCase is called, it should return a different place`() {
        var newPlace: PlaceModel

        repeat((0 until 10000).count()) {
            newPlace = GetRandomCityUseCase()(currentPlace = currentPlace)
            assertNotEquals(currentPlace, newPlace)
        }
    }
}