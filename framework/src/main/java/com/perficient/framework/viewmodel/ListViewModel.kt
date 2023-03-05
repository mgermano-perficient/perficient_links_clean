package com.perficient.framework.viewmodel

import androidx.lifecycle.*
import com.perficient.framework.repository.CountriesRepository
import com.perficient.model.CountryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val countriesRepository: CountriesRepository): ViewModel() {

    private val countriesStateFlow:MutableStateFlow<CountryState> = MutableStateFlow(CountryState.Empty)
    val        _countriesStateFlow:StateFlow<CountryState> = countriesStateFlow

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
        }
    }

}