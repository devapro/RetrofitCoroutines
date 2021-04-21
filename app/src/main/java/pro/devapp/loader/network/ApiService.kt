package pro.devapp.loader.network

import pro.devapp.loader.data.dto.CoursesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("cdn/netology-code/rn-task/76cfe1a32000eec05b18894de3f2a43bebfae874/netology.json")
    suspend fun getCourses(): CoursesResponse
}