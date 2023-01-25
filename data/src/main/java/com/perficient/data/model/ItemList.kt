package com.perficient.data.model

import javax.inject.Inject

// Variables to hold the attributes of the first and second layout.
// The viewType variable specifies which out of the two layouts is expected in the given item
data class ItemList @Inject constructor(
    var viewType: Int,
    var icon: Int,
    var title: String,
    var message: String
) {
    // Integers assigned to each layout are declared static.
    // So that they can be accessed from the class name itself
    companion object {
        const val Layout_One_Kudos = 0
        const val Layout_Two_Employee = 1
    }
}