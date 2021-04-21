package pro.devapp.loader.ui.mapper

import pro.devapp.loader.data.dto.CoursesResponse
import pro.devapp.loader.ui.model.Course
import pro.devapp.loader.ui.model.CourseGroup

class CoursesMapper {

    fun mapCoursesResponseToCoursesList(coursesResponse: CoursesResponse): List<Course> {
        val list = mutableListOf<Course>()
        coursesResponse.data.forEach { data ->
            data.groups.forEach { group ->
                val models = group.items.map {
                    Course(
                        id = it.id,
                        title = it.title,
                        link = it.link,
                        subtitle = group.title
                    )
                }
                list.addAll(models)
            }
        }
        return list
    }

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