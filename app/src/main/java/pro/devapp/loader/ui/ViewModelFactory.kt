package pro.devapp.loader.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pro.devapp.loader.data.repository.CoursesRepository
import pro.devapp.loader.network.ApiService
import pro.devapp.loader.ui.mapper.CoursesMapper
import pro.devapp.loader.ui.screen.MainViewModel

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                CoursesRepository(apiService),
                CoursesMapper()
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}