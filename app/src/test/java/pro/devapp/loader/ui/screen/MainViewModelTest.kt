package pro.devapp.loader.ui.screen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import pro.devapp.loader.common.Status
import pro.devapp.loader.data.repository.CoursesRepository
import pro.devapp.loader.getCoursesGroupList
import pro.devapp.loader.getCoursesResponse
import pro.devapp.loader.getOrAwaitValue
import pro.devapp.loader.ui.mapper.CoursesMapper
import pro.devapp.loader.waitNextValueOrGet

class MainViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    lateinit var viewModel: MainViewModel

    @Mock
    lateinit var repository: CoursesRepository

    @Mock
    lateinit var mapper: CoursesMapper

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel(repository, mapper)
    }

    @Test
    fun `should get correct list when request success`() = runBlocking {
        val expectedResponse = getCoursesResponse()
        val expectedGroupList = getCoursesGroupList()

        Mockito
            .`when`(repository.getCourses())
            .thenReturn(expectedResponse)
        Mockito
            .`when`(mapper.mapCoursesResponseToGroupsList(expectedResponse))
            .thenReturn(expectedGroupList)

        val actualList = viewModel.getCourses()

        assertEquals(Status.LOADING, actualList.getOrAwaitValue().status)
        assertEquals(expectedGroupList, actualList.waitNextValueOrGet().data)
        assertEquals(Status.SUCCESS, actualList.waitNextValueOrGet().status)
    }

    @Test
    fun `should get correct status when request failed`() = runBlocking {
        val expectedResponse = getCoursesResponse()
        val expectedGroupList = getCoursesGroupList()

        Mockito
            .`when`(repository.getCourses())
            .thenAnswer { throw Exception("test") }
        Mockito
            .`when`(mapper.mapCoursesResponseToGroupsList(expectedResponse))
            .thenReturn(expectedGroupList)

        val actualList = viewModel.getCourses()

        assertEquals(Status.LOADING, actualList.getOrAwaitValue().status)
        assertEquals(null, actualList.waitNextValueOrGet().data)
        assertEquals(Status.ERROR, actualList.waitNextValueOrGet().status)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}