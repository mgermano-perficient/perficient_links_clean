package com.perficient.links.di

import com.perficient.model.MainRecyclerViewItem
import com.perficient.presentation.view.PerficientLinkViewAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RecyclerViewAdapterModule {
    @Provides
    fun provideDataSource(): ArrayList<MainRecyclerViewItem> {
        return PerficientLinkViewAdapter.DataSourceForViewAdapter.getDataSourceForViewAdapter()
    }
}