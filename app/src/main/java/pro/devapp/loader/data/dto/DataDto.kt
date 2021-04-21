package pro.devapp.loader.data.dto

import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("groups")
    val groups: List<GroupDto>
)