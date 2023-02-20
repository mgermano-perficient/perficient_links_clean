package com.perficient.framework.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*class CountryService(private val countryApi: CountryApi) {
    suspend fun getCountries() = countryApi.getCountries()
}*/

object CountryService {

   private val BASE_URL = "https://raw.githubusercontent.com"

    fun getCountriesService(): CountryApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }
}
