package com.perficient.framework.viewmodel

import androidx.lifecycle.*
import com.perficient.framework.repository.CountriesRepository
import com.perficient.framework.repository.NewsRepository
import com.perficient.model.CountriesNewsState
import com.perficient.model.CountryState
import com.perficient.model.MainRecyclerViewItem
import com.perficient.model.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val countriesRepository: CountriesRepository,
                                        private val newsRepository: NewsRepository): ViewModel() {

    private val countriesStateFlow:MutableStateFlow<CountryState> = MutableStateFlow(CountryState.Empty)
    //val        _countriesStateFlow:StateFlow<CountryState> = countriesStateFlow

    private val newsStateFlow:MutableStateFlow<NewsState> = MutableStateFlow(NewsState.Empty)
    //val        _newsStateFlow:StateFlow<NewsState> = newsStateFlow

    private val countriesNewsStateFlow:MutableStateFlow<CountriesNewsState> = MutableStateFlow(CountriesNewsState.Empty)
    val         _countriesNewsStateFlow:StateFlow<CountriesNewsState> = countriesNewsStateFlow

    fun fetchCountriesNews() {
        fetchCountriesAndNews()
    }

    private fun fetchCountriesAndNews() {
        viewModelScope.launch {
            countriesNewsStateFlow.value = CountriesNewsState.Loading
            val countries = countriesRepository.getCountries()
            val news = newsRepository.getCountries()
            merge(countries, news)
                .catch { e ->
                    countriesNewsStateFlow.value = CountriesNewsState.Failure(e)
                }
                .collect { data ->
                    countriesNewsStateFlow.value = CountriesNewsState.Success(data)
                }
        }
    }
   /* private fun fetchCountriesAndNews() {
        viewModelScope.launch {
            countriesStateFlow.value = CountryState.Loading
            countriesRepository.getCountries()
                .catch { e ->
                    countriesStateFlow.value = CountryState.Failure(e)
                }
                .collect { data ->
                    countriesStateFlow.value = CountryState.Success(data)
                }

            newsStateFlow.value = NewsState.Loading
            newsRepository.getCountries()
                .catch { e ->
                    newsStateFlow.value = NewsState.Failure(e)
                }
                .collect { data ->
                    newsStateFlow.value = NewsState.Success(data)
                }
        }
    }*/

}