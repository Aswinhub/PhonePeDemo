package com.aswin.phonepe.ui.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aswin.phonepe.databinding.FavouriteListItemViewBinding

class FavouriteListAdapter(private val favouriteListAdapterInterface: FavouriteListAdapterInterface) :
    RecyclerView.Adapter<FavouriteListAdapter.ItemViewHolder>() {

    private val favouriteList = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            FavouriteListItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return favouriteList.size
    }

    inner class ItemViewHolder(private val binding: FavouriteListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.favouriteTv.text = favouriteList[position]
            binding.favouriteTv.setOnClickListener {

            }
        }
    }
}