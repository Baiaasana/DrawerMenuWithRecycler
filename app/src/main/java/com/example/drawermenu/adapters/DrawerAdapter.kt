package com.example.drawermenu.adapters

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.Items
import com.example.drawermenu.Items.Items.filteredListOfItems
import com.example.drawermenu.databinding.MenuItemBinding
import com.example.drawermenu.model.MenuItem
import kotlin.math.log

class DrawerAdapter : ListAdapter<MenuItem, DrawerAdapter.ItemViewHolder>(ItemDiffCallback) {

    var itemClick: ((MenuItem) -> Unit)? = null

    inner class ItemViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = getItem(adapterPosition)
            binding.apply {
                tvTitle.text = item.title.toString()
                item.icon?.let { ivIcon.setImageResource(it) }
                btnNotifications.background.setTint(item.notification_color!!)
                btnNotifications.text = item.notification_number.toString()
                root.setOnClickListener {
                    itemClick?.invoke(item)
                }
                if (item.notification_number != null) {
                    btnNotifications.isVisible = true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind()

    object ItemDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem == newItem
        }
    }

    fun showItemsByType(type: String, allData: List<MenuItem>){

        when (type) {
            Items.Types.BUSINESS.name -> {
                filteredListOfItems = allData.filter { it.type.toString() == Items.Types.BUSINESS.name } as MutableList<MenuItem>
            }
            Items.Types.PERSONAL.name -> {
                filteredListOfItems = allData.filter { it.type.toString() == Items.Types.PERSONAL.name } as MutableList<MenuItem>
            }
            else -> {
                filteredListOfItems = allData as MutableList<MenuItem>
            }
        }
    }


}