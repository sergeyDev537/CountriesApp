package com.most4dev.countriesapp.data

import com.most4dev.countriesapp.data.retrofit.Common
import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.repository.CountriesListRepository

object CountriesRepositoryImpl: CountriesListRepository {

    private val apiInterface = Common.apiInterface
    private var listCountries = listOf<CountriesLong>()

    override suspend fun getCountriesList(): List<CountriesLong>{
        listCountries = apiInterface.getShortFieldsList().body() ?: arrayListOf()
        return listCountries
    }

    override fun getCountry(name: String): CountriesLong? {
        return listCountries.find { it.name == name }
    }
}