package com.perficient.model

sealed class MainRecyclerViewItem {

    class KudosItem(
        var viewType: Int,
        var icon: Int,
        var title: String,
        var message: String
    ) : MainRecyclerViewItem()

    class EmployeeBirthdayItem(
        var viewType: Int,
        var icon: Int,
        var title: String,
        var message: String
    ) : MainRecyclerViewItem()
}
