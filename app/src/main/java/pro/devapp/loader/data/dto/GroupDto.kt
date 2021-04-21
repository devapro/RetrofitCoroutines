package pro.devapp.loader.data.dto

import com.google.gson.annotations.SerializedName

data class GroupDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("items")
    val items: List<CourseDto>
)