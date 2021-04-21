package pro.devapp.loader.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import pro.devapp.loader.common.Resource
import pro.devapp.loader.data.repository.CoursesRepository
import pro.devapp.loader.ui.mapper.CoursesMapper

class MainViewModel(
    private val coursesRepository: CoursesRepository,
    private val mapper: CoursesMapper
) : ViewModel() {

    fun getCourses() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val response = coursesRepository.getCourses()
            emit(Resource.success(data = mapper.mapCoursesResponseToGroupsList(response)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Network error!"))
        }
    }
}