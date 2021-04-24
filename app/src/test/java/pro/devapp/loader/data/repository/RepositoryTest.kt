package pro.devapp.loader.data.repository

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import pro.devapp.loader.getCoursesResponse
import pro.devapp.loader.network.ApiService

class RepositoryTest {

    @Mock
    lateinit var service: ApiService

    lateinit var repository: CoursesRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = CoursesRepository(service)
    }

    @Test
    fun `should get correct response object`() = runBlocking {
        val expectedResponse = getCoursesResponse()

        Mockito
            .`when`(service.getCourses())
            .thenReturn(expectedResponse)

        val actualResponse = repository.getCourses()

        assertEquals(expectedResponse, actualResponse)
    }
}