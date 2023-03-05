package com.perficient.framework.repository

import com.perficient.framework.network.CountryService
import com.perficient.framework.network.InshortNewService
import com.perficient.model.MainRecyclerViewItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepository @Inject constructor(private val inshortNewService: InshortNewService) {
    fun getCountries(): Flow<List<MainRecyclerViewItem.InshortNewsItem>> = flow {
        emit(inshortNewService.getNews())
    }.flowOn(Dispatchers.IO)
}