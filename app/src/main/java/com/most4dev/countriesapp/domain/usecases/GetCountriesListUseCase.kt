package com.most4dev.countriesapp.domain.usecases

import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.repository.CountriesListRepository

class GetCountriesListUseCase(private val countriesListRepository: CountriesListRepository) {

    suspend operator fun invoke(): List<CountriesLong>{
        return countriesListRepository.getCountriesList()
    }

}