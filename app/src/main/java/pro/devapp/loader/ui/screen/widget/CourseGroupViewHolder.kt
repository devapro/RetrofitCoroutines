package pro.devapp.loader.ui.screen.widget

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pro.devapp.loader.R
import pro.devapp.loader.ui.model.CourseGroup

class CourseGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(course: CourseGroup) {
        itemView.apply {
            findViewById<TextView>(R.id.courseTitle).text = course.title
            findViewById<TextView>(R.id.courseSubTitle).text =
                context.resources.getQuantityString(
                    R.plurals.courses_in_group_sub_title,
                    course.totalCourses,
                    course.totalCourses
                )
        }
    }
}