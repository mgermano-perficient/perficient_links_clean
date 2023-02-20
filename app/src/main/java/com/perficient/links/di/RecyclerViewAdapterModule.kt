package com.perficient.links.di

import com.perficient.model.MainRecyclerViewItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RecyclerViewAdapterModule {

    @Provides
    fun provideDataSource(): ArrayList<MainRecyclerViewItem> {
        return ArrayList()
    }

}