package com.example.artgallery.adapter

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artgallery.R
import com.example.artgallery.databinding.CountryItemBinding
import com.example.artgallery.model.Country
import com.example.artgallery.model.CountryItem
import com.example.artgallery.ui.fragments.RegionFragmentDirections

class RegionAdapter() : RecyclerView.Adapter<RegionAdapter.RegionVH>() {


    inner class RegionVH(val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var countries: List<Country>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionVH {
        return RegionVH(
            CountryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RegionVH, position: Int) {
        val current = differ.currentList[position]

        holder.binding.apply {

            flagTextView.text = current.name.common

            Glide.with(flagImageView.context)
                .load(current.flags.png)
                .placeholder(R.drawable.ic_dept_image_placeholder_24)
                .into(flagImageView)
        }

        holder.itemView.setOnClickListener {
            val direction = RegionFragmentDirections.actionGalleryFragmentToDetailsFragment(current)
         it.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int {
        return countries.size
    }

}