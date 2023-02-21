package com.perficient.links.di

import com.perficient.framework.network.InshortNewApi
import com.perficient.framework.network.InshortNewService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InshortNewsApiModule {

    private val BASE_URL ="https://jsonplaceholder.typicode.com"

    @Singleton
    @Provides
    @Named("NewsService")
    fun provideRetrofitNewsService(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideInshortNewApi( @Named("NewsService")retrofit: Retrofit): InshortNewApi =
        retrofit.create(InshortNewApi::class.java)

    @Singleton
    @Provides
    fun provideInshortNewService(inshortNewApi: InshortNewApi) = InshortNewService(inshortNewApi)
}