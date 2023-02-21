package com.perficient.links

import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.perficient.framework.viewmodel.ListViewModel
import com.perficient.links.databinding.ActivityMainBinding
import com.perficient.presentation.view.PerficientLinkViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels()

    // view binding for the activity
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    // Hilt
    @Inject
    lateinit var recyclerViewAdapter: PerficientLinkViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // view binding for the activity
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.refresh()

        binding.rvList .apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                binding.rvList.visibility = View.VISIBLE
                recyclerViewAdapter.updateCountries(it)
            }
        })

        viewModel.shortnews.observe(this, Observer { news ->
            news?.let {
                binding.rvList.visibility = View.VISIBLE
                recyclerViewAdapter.updateNews(it)
            }
        })

       viewModel.loadError.observe(this, Observer { isError ->
           binding.listError.visibility = if (isError == null) View.GONE else View.VISIBLE
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                binding.loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.listError.visibility = View.GONE
                    binding.rvList.visibility = View.GONE
                }
            }
        })
    }

}