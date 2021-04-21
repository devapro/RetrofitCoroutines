package pro.devapp.loader.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import pro.devapp.loader.R
import pro.devapp.loader.common.Status
import pro.devapp.loader.network.RetrofitBuilder
import pro.devapp.loader.ui.ViewModelFactory
import pro.devapp.loader.ui.screen.widget.CourseGroupsAdapter
import pro.devapp.loader.ui.screen.widget.CourseGroupsView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CourseGroupsAdapter

    private lateinit var coursesGroupView: CourseGroupsView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coursesGroupView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        setupViewModel()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getCourses().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        coursesGroupView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { courses -> coursesGroupView.setData(courses) }
                    }
                    Status.ERROR -> {
                        coursesGroupView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        coursesGroupView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(RetrofitBuilder.apiService)
        ).get(MainViewModel::class.java)
    }
}