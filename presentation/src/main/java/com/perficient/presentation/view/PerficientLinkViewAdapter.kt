package com.perficient.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perficient.model.ItemList
import com.perficient.model.MainRecyclerViewItem
import com.perficient.presentation.R
import com.perficient.presentation.databinding.LayoutOneKudosBinding
import com.perficient.presentation.databinding.LayoutTwoEmployeeMsgBinding
import javax.inject.Inject

class PerficientLinkViewAdapter @Inject constructor(private val list: ArrayList<MainRecyclerViewItem>) : RecyclerView.Adapter<MainRecyclerViewHolder>() {

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return when(viewType){

            // Inflate the corresponding layout item and create the associated view holder instance.
            R.layout.layout_one_kudos -> MainRecyclerViewHolder.KudosViewHolder (
                LayoutOneKudosBinding.inflate(LayoutInflater.from(parent.context), parent, false) )

            R.layout.layout_two_employee_msg -> MainRecyclerViewHolder.EmployeeBirthdayViewHolder (
                LayoutTwoEmployeeMsgBinding.inflate(LayoutInflater.from(parent.context), parent, false) )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }

    }

     override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
       when(holder) {
           is MainRecyclerViewHolder.KudosViewHolder -> holder.bind(list[position] as MainRecyclerViewItem.KudosItem)
           is MainRecyclerViewHolder.EmployeeBirthdayViewHolder -> holder.bind(list[position] as MainRecyclerViewItem.EmployeeBirthdayItem)
       }
   }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]){
            is MainRecyclerViewItem.KudosItem -> R.layout.layout_one_kudos
            is MainRecyclerViewItem.EmployeeBirthdayItem -> R.layout.layout_two_employee_msg
        }
    }

    object DataSourceForViewAdapter {
        fun getDataSourceForViewAdapter(): ArrayList<MainRecyclerViewItem> {
            val dataList = ArrayList<MainRecyclerViewItem>()
            dataList.add(MainRecyclerViewItem.EmployeeBirthdayItem(ItemList.Layout_Two_Employee, R.drawable.cake48, "Juan Targarna", "Muy Feliz Cumpleaños Juan"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de Disney", "Pedro, has hecho un gran trabajo"))
            dataList.add(MainRecyclerViewItem.EmployeeBirthdayItem(ItemList.Layout_Two_Employee, R.drawable.cake48, "Romina Romaniuk", "Muy Feliz Cumpleaños Romina"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de Canadian Toys", "Tania, 10 años en el empresa"))
            dataList.add(MainRecyclerViewItem.EmployeeBirthdayItem(ItemList.Layout_Two_Employee, R.drawable.cake48, "Pedro De la Cruz", "Muy Feliz Cumpleaños Pedro"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.congrats,  "Kudos de IBM", "Silvia, felicitaciones por el lanzamiento de X23"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Carlos Garcia", "Que pases un lindo dia"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Marcela Clay", "Felicidades, lo mejor para vos en este dia"))
            dataList.add(MainRecyclerViewItem.KudosItem(ItemList.Layout_One_Kudos, R.drawable.cake48,    "Carlos Dio", "Te deseamos que tengas un gran dia"))
            return dataList
        }
    }
}
