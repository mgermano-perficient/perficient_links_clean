package com.perficient.framework.retrofit

import com.perficient.model.MainRecyclerViewItem
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    suspend fun getCountries(): Response<List<MainRecyclerViewItem.CountryItem>>
}