package com.perficient.presentation.view

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.perficient.model.MainRecyclerViewItem
import com.perficient.presentation.databinding.ItemCountryBinding
import com.perficient.presentation.databinding.ItemInshortNewsBinding

// SEALED VIEW HOLDERS
sealed class MainRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class CountryViewHolder(private val countryItemBinding: ItemCountryBinding) : MainRecyclerViewHolder(countryItemBinding){
        fun bind(countryItem: MainRecyclerViewItem.CountryItem){
            countryItemBinding.apply{
                Glide.with(countryFlag.context).load(countryItem.flag).into(countryFlag)
                countryName.text = countryItem.countryName
                countryCapitalCity.text = countryItem.capitalCity
            }
        }
    }

    class InshortNewsViewHolder(private val itemInshortNewsBinding: ItemInshortNewsBinding) : MainRecyclerViewHolder(itemInshortNewsBinding){
        fun bind(inshortNewsItem: MainRecyclerViewItem.InshortNewsItem){
            itemInshortNewsBinding.apply{
                headline.text = inshortNewsItem.headline
                author.text = inshortNewsItem.user
                content.text = inshortNewsItem.latinTxt
            }
        }
    }
}
