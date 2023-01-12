package com.most4dev.countriesapp.domain.usecases

import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.repository.CountriesListRepository

class GetCountryUseCase(private val repository: CountriesListRepository) {

    suspend operator fun invoke(name: String): CountriesLong?{
        return repository.getCountry(name)
    }

}