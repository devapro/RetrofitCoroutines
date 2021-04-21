package pro.devapp.loader.data.dto

import com.google.gson.annotations.SerializedName

data class CoursesResponse (
    @SerializedName("data")
    val data: List<DataDto>
)