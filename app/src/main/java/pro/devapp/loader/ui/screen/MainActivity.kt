package pro.devapp.loader.ui.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import pro.devapp.loader.R
import pro.devapp.loader.network.RetrofitBuilder
import pro.devapp.loader.ui.ViewModelFactory
import pro.devapp.loader.ui.model.CourseGroup
import pro.devapp.loader.ui.screen.widget.CourseGroupsAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CourseGroupsAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = CourseGroupsAdapter {
            Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
        }

        setupViewModel()
        setupRecycler()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(RetrofitBuilder.apiService)
        ).get(MainViewModel::class.java)
    }

    private fun setupRecycler() {
        recyclerView.adapter = adapter
        adapter.courses = listOf(
            CourseGroup(
                title = "First course",
                totalCourses = 2
            ),
            CourseGroup(
                title = "Second course",
                totalCourses = 10
            )
        )
    }
}