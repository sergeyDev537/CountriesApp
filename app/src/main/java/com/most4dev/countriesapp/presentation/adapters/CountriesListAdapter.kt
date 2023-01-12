package com.most4dev.countriesapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.most4dev.countriesapp.databinding.ItemCountryBinding
import com.most4dev.countriesapp.domain.entity.CountriesShort

class CountriesListAdapter: ListAdapter<CountriesShort, CountriesViewHolder>(CountriesDiffCallback()) {

    var onCountryItemClickListener: ((CountriesShort) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val binding = ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CountriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val countryItem = getItem(position)
        val binding = holder.binding

        binding.countryItem = countryItem

        binding.root.setOnClickListener {
            onCountryItemClickListener?.invoke(countryItem)
        }
    }


}