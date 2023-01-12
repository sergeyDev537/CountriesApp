package com.most4dev.countriesapp.domain.usecases

import androidx.lifecycle.LiveData
import com.most4dev.countriesapp.domain.entity.CountriesShort
import com.most4dev.countriesapp.domain.repository.CountriesListRepository

class GetCountriesListUseCase(private val countriesListRepository: CountriesListRepository) {

    operator fun invoke(): LiveData<List<CountriesShort>>{
        return countriesListRepository.getCountriesList()
    }

}