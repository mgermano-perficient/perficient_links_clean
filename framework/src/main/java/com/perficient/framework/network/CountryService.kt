package com.perficient.framework.network

class CountryService(private val countryApi: CountryApi) {
    suspend fun getCountries() = countryApi.getCountries()
}