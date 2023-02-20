package com.perficient.model

import com.google.gson.annotations.SerializedName

sealed class MainRecyclerViewItem{

    class CountryItem(
        @SerializedName("name")
        val countryName: String?,

        @SerializedName("capital")
        val capitalCity: String?,

        @SerializedName("flagPNG")
        val flag: String?
    ) : MainRecyclerViewItem()

    class InshortNewsItem(
        @SerializedName("userId")
        val user: String?,

        @SerializedName("title")
        val headline: String?,

        @SerializedName("body")
        val latinTxt: String?
    ) : MainRecyclerViewItem()

}
