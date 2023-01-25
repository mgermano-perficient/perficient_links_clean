package com.perficient.framework.di

import com.perficient.data.model.ItemList
import com.perficient.framework.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RecyclerViewAdapterModule {

    @Provides
    fun provideDataSource(): ArrayList<ItemList> {
        return DataSourceForViewAdapter.getDataSourceForViewAdapter()
    }

    object DataSourceForViewAdapter {
        fun getDataSourceForViewAdapter(): ArrayList<ItemList> {
            val dataList = ArrayList<ItemList>()
            dataList.add(ItemList(ItemList.Layout_Two_Employee, R.drawable.cake48, "Juan Targarna", "Muy Feliz Cumpleaños Juan"))
            dataList.add(ItemList(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de Disney", "Pedro, has hecho un gran trabajo"))
            dataList.add(ItemList(ItemList.Layout_Two_Employee, R.drawable.cake48, "Romina Romaniuk", "Muy Feliz Cumpleaños Romina"))
            dataList.add(ItemList(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de Canadian Toys", "Tania, 10 años en el empresa"))
            dataList.add(ItemList(ItemList.Layout_Two_Employee, R.drawable.cake48, "Pedro De la Cruz", "Muy Feliz Cumpleaños Pedro"))
            dataList.add(ItemList(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de IBM", "Silvia, felicitaciones por el lanzamiento de X23"))
            dataList.add(ItemList(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Carlos Garcia", "Que pases un lindo dia"))
            dataList.add(ItemList(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Marcela Clay", "Felicidades, lo mejor para vos en este dia"))
            dataList.add(ItemList(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Carlos Dio", "Te deseamos que tengas un gran dia"))
            return dataList
        }
    }
}