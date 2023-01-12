package com.most4dev.countriesapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.most4dev.countriesapp.domain.entity.CountriesShort

class CountriesDiffCallback: DiffUtil.ItemCallback<CountriesShort>() {
    override fun areItemsTheSame(oldItem: CountriesShort, newItem: CountriesShort): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CountriesShort, newItem: CountriesShort): Boolean {
        return oldItem == newItem
    }
}