package com.most4dev.countriesapp.domain.repository

import com.most4dev.countriesapp.domain.entity.CountriesLong

interface CountriesListRepository {

    suspend fun getCountriesList(): List<CountriesLong>

    fun getCountry(name: String): CountriesLong?

}