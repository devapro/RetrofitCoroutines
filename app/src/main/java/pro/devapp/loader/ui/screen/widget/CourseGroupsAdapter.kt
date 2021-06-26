package pro.devapp.loader.ui.screen.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pro.devapp.loader.R
import pro.devapp.loader.ui.model.CourseGroup

typealias OnClickListener = (course: CourseGroup) -> Unit

class CourseGroupsAdapter(private val onClickListener: OnClickListener): RecyclerView.Adapter<CourseGroupViewHolder>() {

    var courses = emptyList<CourseGroup>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseGroupViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_course_group, parent, false)
        return CourseGroupViewHolder(viewItem, onClickListener)
    }

    override fun getItemCount(): Int = courses.size

    override fun onBindViewHolder(holder: CourseGroupViewHolder, position: Int) {
        holder.bind(courses[position])
    }
}