package pro.devapp.loader.data.repository

import pro.devapp.loader.network.ApiService

class CoursesRepository (
    private val apiService: ApiService
) {

    suspend fun getCourses() = apiService.getCourses()
}