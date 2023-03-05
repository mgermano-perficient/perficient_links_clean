package com.perficient.model

sealed class CountryState {
    object Empty : CountryState()
    object Loading : CountryState()
    class Failure(val msg:Throwable) : CountryState()
    class Success(val data:List<MainRecyclerViewItem.CountryItem>) : CountryState()
}
