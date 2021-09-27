package fr.r4phab.weather.interactors

import com.squareup.moshi.Moshi
import fr.r4phab.weather.data.apis.OWAPI
import fr.r4phab.weather.data.entities.OWOneCallResponseEntity
import fr.r4phab.weather.domain.models.PositionModel
import fr.r4phab.weather.interactors.repositories.ReleaseWeatherRepository
import fr.r4phab.weather.testing.BaseTest
import fr.r4phab.weather.testing.readAsset
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReleaseWeatherRepositoryTests : BaseTest() {

    private val owApi = mockk<OWAPI>()
    private val repository = ReleaseWeatherRepository(
        owApi = owApi
    )

    @BeforeAll
    override fun beforeAll(){
        super.beforeAll()

        startKoin {  }
        fr.r4phab.weather.data.init()
        init()

        coEvery { owApi.oneCall(any(), any(), any()) } answers {
            KoinJavaComponent
                .get<Moshi>(Moshi::class.java)
                .adapter(OWOneCallResponseEntity::class.java)
                .fromJson(readAsset("json/OWOneCallResponseEntity.json"))!!
        }
    }

    @BeforeEach
    fun beforeEach() {}

    @Test
    fun `When repo is asked to get weather information, it sould call the API`() {
        coVerify(exactly = 0) { owApi.oneCall(any(), any(), any()) }

        runBlockingTest {
            repository.getWeather(PositionModel(0.0, 0.0))
        }

        coVerify(exactly = 1) { owApi.oneCall(any(), any(), any()) }
    }
}