package com.perficient.links.di

import com.perficient.framework.network.CountryApi
import com.perficient.framework.network.CountryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CountryApiModule {

    private val BASE_URL = "https://raw.githubusercontent.com"

    @Singleton
    @Provides
    @Countries
    fun provideRetrofitCountriesService(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideCountryApi(@Countries retrofit: Retrofit): CountryApi =
        retrofit.create(CountryApi::class.java)

    @Singleton
    @Provides
    fun provideCountryService(countryApi: CountryApi) = CountryService(countryApi)
}