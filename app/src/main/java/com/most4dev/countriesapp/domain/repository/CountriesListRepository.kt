package com.most4dev.countriesapp.domain.repository

import androidx.lifecycle.LiveData
import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.entity.CountriesShort

interface CountriesListRepository {

    fun getCountriesList(): LiveData<List<CountriesShort>>

    fun getCountry(name: String): CountriesLong

}