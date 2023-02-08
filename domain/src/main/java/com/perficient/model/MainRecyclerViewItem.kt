package com.perficient.model

import com.google.gson.annotations.SerializedName

sealed class MainRecyclerViewItem {

    class CountryItem(
        @SerializedName("name")
        val countryName: String?,

        @SerializedName("capital")
        val capitalCity: String?,

        @SerializedName("flagPNG")
        val flag: String?
    ) : MainRecyclerViewItem()

}
