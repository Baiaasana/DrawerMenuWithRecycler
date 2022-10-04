package com.example.drawermenu.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.databinding.HeaderItemBinding
import com.example.drawermenu.model.TypeItem

class HeaderAdapter : ListAdapter<TypeItem, HeaderAdapter.ItemTypeViewHolder>(ItemDiffCallback) {

    var itemClick: ((TypeItem) -> Unit)? = null

    inner class ItemTypeViewHolder(private val binding: HeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = getItem(adapterPosition)
            binding.apply {
                tvType.text = item.type.toString()
                tvType.setOnClickListener {
                    itemClick?.invoke(item)


                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTypeViewHolder {
        return ItemTypeViewHolder(HeaderItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ItemTypeViewHolder, position: Int) = holder.bind()

    object ItemDiffCallback : DiffUtil.ItemCallback<TypeItem>() {
        override fun areItemsTheSame(oldItem: TypeItem, newItem: TypeItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TypeItem, newItem: TypeItem): Boolean {
            return oldItem == newItem
        }
    }
}



