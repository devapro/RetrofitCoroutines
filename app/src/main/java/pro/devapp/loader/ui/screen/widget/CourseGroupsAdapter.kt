package pro.devapp.loader.ui.screen.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pro.devapp.loader.R
import pro.devapp.loader.ui.model.CourseGroup

class CourseGroupsAdapter: RecyclerView.Adapter<CourseGroupViewHolder>() {

    private val courses = mutableListOf<CourseGroup>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseGroupViewHolder =
        CourseGroupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_course_group, parent, false))

    override fun getItemCount(): Int = courses.size

    override fun onBindViewHolder(holder: CourseGroupViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    fun setData(courses: List<CourseGroup>) {
        this.courses.apply {
            clear()
            addAll(courses)
        }
        notifyDataSetChanged()
    }
}