package com.perficient.framework.network

import com.perficient.model.MainRecyclerViewItem
import retrofit2.Response
import retrofit2.http.GET

interface InshortNewApi {

    //@GET("news?category=science")
    @GET("posts")
    suspend fun getNews(): Response<List<MainRecyclerViewItem.InshortNewsItem>>
}