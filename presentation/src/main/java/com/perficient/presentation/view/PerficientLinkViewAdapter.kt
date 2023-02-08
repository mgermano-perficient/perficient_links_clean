package com.perficient.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perficient.model.MainRecyclerViewItem
import com.perficient.presentation.R
import com.perficient.presentation.databinding.ItemCountryBinding
import javax.inject.Inject

class PerficientLinkViewAdapter @Inject constructor(private val list: ArrayList<MainRecyclerViewItem>) : RecyclerView.Adapter<MainRecyclerViewHolder>() {

    fun updateCountries(newCountries: List<MainRecyclerViewItem.CountryItem>) {
        list.clear()
        list.addAll(newCountries)
        notifyDataSetChanged()
    }


    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return when(viewType){

            // Inflate the corresponding layout item and create the associated view holder instance.
            R.layout.item_country -> MainRecyclerViewHolder.CountryViewHolder (
                ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false) )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }

    }

     override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
       when(holder) {
           is MainRecyclerViewHolder.CountryViewHolder -> holder.bind(list[position] as MainRecyclerViewItem.CountryItem)
       }
   }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]){
            is MainRecyclerViewItem.CountryItem -> R.layout.item_country
        }
    }

    object DataSourceForViewAdapter {
        fun getDataSourceForViewAdapter(): ArrayList<MainRecyclerViewItem> {
            val dataList = ArrayList<MainRecyclerViewItem>()

           /* dataList.add(MainRecyclerViewItem.EmployeeBirthdayItem(ItemList.Layout_Two_Employee, R.drawable.cake48, "Juan Targarna", "Muy Feliz Cumpleaños Juan"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de Disney", "Pedro, has hecho un gran trabajo"))
            dataList.add(MainRecyclerViewItem.EmployeeBirthdayItem(ItemList.Layout_Two_Employee, R.drawable.cake48, "Romina Romaniuk", "Muy Feliz Cumpleaños Romina"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de Canadian Toys", "Tania, 10 años en el empresa"))
            dataList.add(MainRecyclerViewItem.EmployeeBirthdayItem(ItemList.Layout_Two_Employee, R.drawable.cake48, "Pedro De la Cruz", "Muy Feliz Cumpleaños Pedro"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de IBM", "Silvia, felicitaciones por el lanzamiento de X23"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Carlos Garcia", "Que pases un lindo dia"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Marcela Clay", "Felicidades, lo mejor para vos en este dia"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Carlos Dio", "Te deseamos que tengas un gran dia"))
           */
            return dataList
        }
    }
}
