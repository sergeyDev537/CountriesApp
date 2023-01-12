package com.most4dev.countriesapp.domain.usecases

import com.most4dev.countriesapp.domain.entity.CountriesShort
import com.most4dev.countriesapp.domain.repository.CountriesListRepository

class GetCountriesListUseCase(private val countriesListRepository: CountriesListRepository) {

    suspend operator fun invoke(): List<CountriesShort>{
        return countriesListRepository.getCountriesList()
    }

}