package pro.devapp.loader.data.dto

import com.google.gson.annotations.SerializedName

data class CourseDto (
    @SerializedName("id")
    val id: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("title")
    val title: String
)