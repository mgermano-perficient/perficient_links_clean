package com.perficient.framework.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InshortNewService {

    //private val BASE_URL = "https://inshorts.deta.dev"

    private val BASE_URL ="https://jsonplaceholder.typicode.com"

    fun getShortNewsService(): InshortNewApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InshortNewApi::class.java)
    }
}