package fr.r4phab.weather.data

import com.squareup.moshi.Moshi
import fr.r4phab.weather.data.entities.OWOneCallResponseEntity
import fr.r4phab.weather.testing.BaseTest
import fr.r4phab.weather.testing.readAsset
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.get
import kotlin.test.assertNotNull

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomApplicationTests : BaseTest() {

    @BeforeAll
    override fun beforeAll(){
        super.beforeAll()
        startKoin {  }
        init()
    }

    @BeforeEach
    fun beforeEach() {

    }

    @Test
    fun `When API is returning a response, it should be deserialized successfully`() {
        val json = readAsset("json/OWOneCallResponseEntity.json")

        val entity = get<Moshi>(Moshi::class.java)
            .adapter(OWOneCallResponseEntity::class.java)
            .fromJson(json)

        assertNotNull(entity)
    }
}