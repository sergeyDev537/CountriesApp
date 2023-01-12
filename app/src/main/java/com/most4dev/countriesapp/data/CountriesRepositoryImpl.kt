package com.most4dev.countriesapp.data

import com.most4dev.countriesapp.data.retrofit.Common
import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.entity.CountriesShort
import com.most4dev.countriesapp.domain.repository.CountriesListRepository

object CountriesRepositoryImpl: CountriesListRepository {

    private val apiInterface = Common.apiInterface

    override suspend fun getCountriesList(): List<CountriesShort>{
        return apiInterface.getShortFieldsList().body() ?: arrayListOf()
    }

    override suspend fun getCountry(name: String): CountriesLong {
        return apiInterface.getLongFieldsItem(name)
    }
}