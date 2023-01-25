package com.perficient.presentation.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perficient.data.model.ItemList
import com.perficient.presentation.databinding.LayoutOneKudosBinding
import com.perficient.presentation.databinding.LayoutTwoEmployeeMsgBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PerficientLinkViewAdapter @Inject constructor(@ApplicationContext private val context: Context, private val list: ArrayList<ItemList>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        when (list[position].viewType) {
            ItemList.Layout_One_Kudos    ->  return ItemList.Layout_One_Kudos
            ItemList.Layout_Two_Employee ->  return ItemList.Layout_One_Kudos
            else  -> return -1
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val inflater = LayoutInflater.from(viewGroup.context)

        // view binding for the RecyclerView + ViewHolder
        when (viewType) {
            ItemList.Layout_One_Kudos -> {
                val itemViewBinding = LayoutOneKudosBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
                viewHolder = ViewHolderKudos(itemViewBinding)
            }

            ItemList.Layout_Two_Employee -> {
                val itemViewBinding = LayoutTwoEmployeeMsgBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
                viewHolder = ViewHolderEmployee(itemViewBinding)
            }

            else -> {
                val v: View = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false)
                viewHolder =  RecyclerViewSimpleTextViewHolder(v)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder.itemViewType) {
            ItemList.Layout_One_Kudos -> {
                val viewHolderKudos = viewHolder as ViewHolderKudos
                bindViewHolderKudos(viewHolderKudos, position)
            }
            ItemList.Layout_Two_Employee -> {
                val viewHolderEmployee = viewHolder as ViewHolderEmployee
                bindViewHolderEmployee(viewHolderEmployee, position)
            }
        }
    }

    // VIEW HOLDERS
    inner class ViewHolderKudos(private val itemViewBinding: LayoutOneKudosBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(itemList: ItemList) {
            itemViewBinding.apply {
                kudosTitle.text = itemList.title
                kudosTextArea.text = itemList.message
                kudosImage.setImageResource(itemList.icon)
            }
        }
    }

    inner class ViewHolderEmployee(private val itemViewBinding: LayoutTwoEmployeeMsgBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(itemList: ItemList) {
            itemViewBinding.apply {
                employeeName.text = itemList.title
                employeeMessage.text = itemList.message
                employeeImage.setImageResource(itemList.icon)
            }
        }
    }

    class RecyclerViewSimpleTextViewHolder(v: View) : RecyclerView.ViewHolder(v)

    // Binding View Holder Functions
    private fun bindViewHolderKudos(vhKudos: ViewHolderKudos, position: Int) {
        val itemList = list[position]
        vhKudos.bind(itemList)
    }

    private fun bindViewHolderEmployee(vhEmployee: ViewHolderEmployee, position: Int) {
        val itemList = list[position]
        vhEmployee.bind(itemList)
    }

}