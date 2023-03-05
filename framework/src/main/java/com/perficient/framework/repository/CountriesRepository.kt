package com.perficient.framework.repository

import com.perficient.framework.network.CountryService
import com.perficient.model.MainRecyclerViewItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class CountriesRepository @Inject constructor(private val countryService: CountryService) {

    fun getCountries(): Flow<List<MainRecyclerViewItem.CountryItem>> = flow {
        emit(countryService.getCountries())
    }.flowOn(Dispatchers.IO)
}