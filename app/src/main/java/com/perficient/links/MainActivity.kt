package com.perficient.links

import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.perficient.framework.viewmodel.ListViewModel
import com.perficient.links.databinding.ActivityMainBinding
import com.perficient.model.CountriesNewsState
import com.perficient.model.CountryState
import com.perficient.model.NewsState
import com.perficient.presentation.view.PerficientLinkViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // view binding for the activity
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    // Hilt
    @Inject
    lateinit var recyclerViewAdapter: PerficientLinkViewAdapter
    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // view binding for the activity
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchCountriesNews()

        binding.rvList .apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }

         lifecycleScope.launchWhenStarted {
            viewModel._countriesNewsStateFlow.collect { it ->
                when (it) {
                    is CountriesNewsState.Loading -> {
                        binding.rvList.isVisible = false
                        binding.loadingView.isVisible = true
                    }
                    is CountriesNewsState.Failure -> {
                        binding.rvList.isVisible = false
                        binding.loadingView.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is CountriesNewsState.Success -> {
                        binding.rvList.isVisible = true
                        binding.loadingView.isVisible = false
                        recyclerViewAdapter.updateCountriesNews(it.data)
                        recyclerViewAdapter.notifyDataSetChanged()
                    }
                    is CountriesNewsState.Empty -> {

                    }
                }
            }
        }



        /*lifecycleScope.launchWhenStarted  {

           *//* viewModel._countriesStateFlow.collect { it ->
                when (it) {
                    is CountryState.Loading -> {
                        binding.rvList.isVisible = false
                        binding.loadingView.isVisible = true
                    }
                    is CountryState.Failure -> {
                        binding.rvList.isVisible = false
                        binding.loadingView.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is CountryState.Success -> {
                        binding.rvList.isVisible = true
                        binding.loadingView.isVisible = false
                        recyclerViewAdapter.updateCountries(it.data)
                        recyclerViewAdapter.notifyDataSetChanged()
                    }
                    is CountryState.Empty -> {

                    }
                }
            }*//*
        }*/

       /* lifecycleScope.launchWhenStarted {
            viewModel._newsStateFlow.collect { it ->
                when (it) {
                    is NewsState.Loading -> {
                        binding.rvList.isVisible = false
                        binding.loadingView.isVisible = true
                    }
                    is NewsState.Failure -> {
                        binding.rvList.isVisible = false
                        binding.loadingView.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is NewsState.Success -> {
                        binding.rvList.isVisible = true
                        binding.loadingView.isVisible = false
                        recyclerViewAdapter.updateNews(it.data)
                        recyclerViewAdapter.notifyDataSetChanged()
                    }
                    is NewsState.Empty -> {

                    }
                }
            }
        }*/
    }
}