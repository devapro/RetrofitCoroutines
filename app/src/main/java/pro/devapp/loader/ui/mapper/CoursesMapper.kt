package pro.devapp.loader.ui.mapper

import pro.devapp.loader.data.dto.CoursesResponse
import pro.devapp.loader.ui.model.CourseGroup

class CoursesMapper {

    fun mapCoursesResponseToGroupsList(coursesResponse: CoursesResponse): List<CourseGroup> {
        val list = mutableListOf<CourseGroup>()
        coursesResponse.data.forEach { data ->
            val models = data.groups.map { group ->
                CourseGroup(
                    title = group.title,
                    totalCourses = group.items.size
                )
            }
            list.addAll(models)
        }
        return list
    }
}