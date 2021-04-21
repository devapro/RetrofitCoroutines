package pro.devapp.loader.ui.screen.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pro.devapp.loader.ui.model.CourseGroup

class CourseGroupsView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        layoutManager = LinearLayoutManager(context)
        addItemDecoration(
            DividerItemDecoration(
                context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
        adapter = CourseGroupsAdapter()
    }

    fun setData(courses: List<CourseGroup>) {
        (adapter as CourseGroupsAdapter).setData(courses)
    }
}