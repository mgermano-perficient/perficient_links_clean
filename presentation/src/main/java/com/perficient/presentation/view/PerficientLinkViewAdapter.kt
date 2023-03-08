package com.perficient.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perficient.model.MainRecyclerViewItem
import com.perficient.presentation.R
import com.perficient.presentation.databinding.ItemCountryBinding
import com.perficient.presentation.databinding.ItemInshortNewsBinding
import javax.inject.Inject

class PerficientLinkViewAdapter @Inject constructor(private val list: ArrayList<MainRecyclerViewItem>) : RecyclerView.Adapter<MainRecyclerViewHolder>() {

    fun updateCountries(newCountries: List<MainRecyclerViewItem.CountryItem>) {
        list.addAll(newCountries)
        notifyDataSetChanged()
    }

    fun updateNews(newShortNews: List<MainRecyclerViewItem.InshortNewsItem>) {
        list.addAll(newShortNews)
        notifyDataSetChanged()
    }

    fun updateCountriesNews(newCountriesNews: List<MainRecyclerViewItem>) {
        list.addAll(newCountriesNews)
        notifyDataSetChanged()
    }


    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return when(viewType){

            // Inflate the corresponding layout item and create the associated view holder instance.
            R.layout.item_country -> MainRecyclerViewHolder.CountryViewHolder (
                ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false) )

            R.layout.item_inshort_news -> MainRecyclerViewHolder.InshortNewsViewHolder (
                ItemInshortNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false) )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }

    }

     override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
       when(holder) {
           is MainRecyclerViewHolder.CountryViewHolder -> holder.bind(list[position] as MainRecyclerViewItem.CountryItem)
           is MainRecyclerViewHolder.InshortNewsViewHolder -> holder.bind(list[position] as MainRecyclerViewItem.InshortNewsItem)
       }
   }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]){
            is MainRecyclerViewItem.CountryItem -> R.layout.item_country
            is MainRecyclerViewItem.InshortNewsItem -> R.layout.item_inshort_news
            else -> throw IllegalArgumentException("Invalid getItemViewType Provided")
        }
    }
}
