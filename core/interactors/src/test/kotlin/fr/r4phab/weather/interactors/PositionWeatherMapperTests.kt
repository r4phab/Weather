package fr.r4phab.weather.interactors

import com.soywiz.klock.DayOfWeek
import com.squareup.moshi.Moshi
import fr.r4phab.weather.data.entities.OWOneCallResponseEntity
import fr.r4phab.weather.interactors.mappers.asModel
import fr.r4phab.weather.testing.BaseTest
import fr.r4phab.weather.testing.readAsset
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PositionWeatherMapperTests : BaseTest() {

    @BeforeAll
    override fun beforeAll(){
        super.beforeAll()
        startKoin {  }
        fr.r4phab.weather.data.init()
        init()
    }

    private var entity: OWOneCallResponseEntity? = null

    @BeforeEach
    fun beforeEach() {
        entity = KoinJavaComponent
            .get<Moshi>(Moshi::class.java)
            .adapter(OWOneCallResponseEntity::class.java)
            .fromJson(readAsset("json/OWOneCallResponseEntity.json"))
    }

    @Test
    fun `When entity is mapped to Model, current weather is today`() {
        assertNotNull(entity)
        val model = entity!!.asModel()

        assertEquals(DayOfWeek.Monday, model.current.day)
    }

    @Test
    fun `When entity is mapped to Model, forecast starts at tomorrow`() {
        assertNotNull(entity)
        val model = entity!!.asModel()

        assertEquals(DayOfWeek.Tuesday, model.forecast[0].day)
        assertEquals(DayOfWeek.Wednesday, model.forecast[1].day)
    }
}