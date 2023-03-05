package com.perficient.model

sealed class NewsState {
    object Empty : NewsState()
    object Loading : NewsState()
    class Failure(val msg:Throwable) : NewsState()
    class Success(val data:List<MainRecyclerViewItem.InshortNewsItem>) : NewsState()
}

