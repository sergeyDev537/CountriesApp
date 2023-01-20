package com.most4dev.countriesapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.most4dev.countriesapp.domain.entity.CountriesLong

class CountriesDiffCallback: DiffUtil.ItemCallback<CountriesLong>() {
    override fun areItemsTheSame(oldItem: CountriesLong, newItem: CountriesLong): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CountriesLong, newItem: CountriesLong): Boolean {
        return oldItem == newItem
    }
}