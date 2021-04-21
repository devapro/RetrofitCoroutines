package pro.devapp.loader

import pro.devapp.loader.data.dto.CourseDto
import pro.devapp.loader.data.dto.CoursesResponse
import pro.devapp.loader.data.dto.DataDto
import pro.devapp.loader.data.dto.GroupDto
import pro.devapp.loader.ui.model.CourseGroup

fun getCourseGroupModel(): CourseGroup {
    return CourseGroup(
        title = "First",
        totalCourses = 1
    )
}

fun getCoursesGroupList() = listOf(getCourseGroupModel())

fun getCoursesResponse(): CoursesResponse {
    val items = listOf(
        CourseDto(
            id = "159bf7c0-c5cf-4b75-8f59-fdf2b33291d3",
            link = "https://google.com",
            title = "Course title"
        )
    )
    val groups = listOf(
        GroupDto(
            title = "First",
            items = items
        )
    )
    val data = listOf(
        DataDto(groups)
    )
    return CoursesResponse(data)
}