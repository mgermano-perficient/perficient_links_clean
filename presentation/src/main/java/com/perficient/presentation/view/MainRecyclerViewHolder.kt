package com.perficient.presentation.view

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.perficient.model.MainRecyclerViewItem
import com.perficient.presentation.databinding.LayoutOneKudosBinding
import com.perficient.presentation.databinding.LayoutTwoEmployeeMsgBinding

// SEALED VIEW HOLDERS
sealed class MainRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class KudosViewHolder(private val kudosItemBinding: LayoutOneKudosBinding) : MainRecyclerViewHolder(kudosItemBinding){
        fun bind(kudosItem: MainRecyclerViewItem.KudosItem){
            kudosItemBinding.apply{
                kudosTitle.text = kudosItem.title
                kudosTextArea.text = kudosItem.message
                kudosImage.setImageResource(kudosItem.icon)
            }
        }
    }

    class EmployeeBirthdayViewHolder(private val employeeItemBinding: LayoutTwoEmployeeMsgBinding) : MainRecyclerViewHolder(employeeItemBinding){
        fun bind(employeeBirthdayItem: MainRecyclerViewItem.EmployeeBirthdayItem){
            employeeItemBinding.apply{
                employeeName.text = employeeBirthdayItem.title
                employeeMessage.text = employeeBirthdayItem.message
                employeeImage.setImageResource(employeeBirthdayItem.icon)
            }
        }
    }

}
