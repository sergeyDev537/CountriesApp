package com.most4dev.countriesapp.domain.repository

import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.entity.CountriesShort

interface CountriesListRepository {

    suspend fun getCountriesList(): List<CountriesShort>

    suspend fun getCountry(name: String): CountriesLong?

}