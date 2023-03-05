package com.perficient.framework.viewmodel

import androidx.lifecycle.*
import com.perficient.framework.repository.CountriesRepository
import com.perficient.framework.repository.NewsRepository
import com.perficient.model.CountryState
import com.perficient.model.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val countriesRepository: CountriesRepository,
                                        private val newsRepository: NewsRepository): ViewModel() {

    private val countriesStateFlow:MutableStateFlow<CountryState> = MutableStateFlow(CountryState.Empty)
    val        _countriesStateFlow:StateFlow<CountryState> = countriesStateFlow

    private val newsStateFlow:MutableStateFlow<NewsState> = MutableStateFlow(NewsState.Empty)
    val        _newsStateFlow:StateFlow<NewsState> = newsStateFlow

    fun fetchCountriesNews() {
        fetchCountriesAndNews()
    }

    private fun fetchCountriesAndNews() {
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
    }

}