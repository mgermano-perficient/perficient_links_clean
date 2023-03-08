package com.perficient.model

sealed class CountriesNewsState {
    object Empty : CountriesNewsState()
    object Loading : CountriesNewsState()
    class Failure(val msg:Throwable) : CountriesNewsState()
    class Success(val data:List<MainRecyclerViewItem>) : CountriesNewsState()
}
