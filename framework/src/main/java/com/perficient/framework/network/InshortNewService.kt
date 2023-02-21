package com.perficient.framework.network

class InshortNewService(private val inshortNewApi: InshortNewApi) {
    suspend fun getNews() = inshortNewApi.getNews()
}
