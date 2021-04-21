package pro.devapp.loader.ui.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pro.devapp.loader.getCoursesGroupList
import pro.devapp.loader.getCoursesResponse

class CoursesMapperTest {

    lateinit var mapper: CoursesMapper

    @Before
    fun setup() {
        mapper = CoursesMapper()
    }

    @Test
    fun `should correct map`() {
        val expectedList = getCoursesGroupList()
        val expectedResponse = getCoursesResponse()

        assertEquals(expectedList, mapper.mapCoursesResponseToGroupsList(expectedResponse))
    }
}