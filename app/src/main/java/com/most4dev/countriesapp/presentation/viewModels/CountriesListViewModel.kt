package com.most4dev.countriesapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.most4dev.countriesapp.data.CountriesRepositoryImpl
import com.most4dev.countriesapp.domain.entity.CountriesShort
import com.most4dev.countriesapp.domain.usecases.GetCountriesListUseCase
import kotlinx.coroutines.launch

class CountriesListViewModel : ViewModel() {

    private var repository = CountriesRepositoryImpl

    private val getCountriesListUseCase = GetCountriesListUseCase(repository)

    private var _listCountry = MutableLiveData<List<CountriesShort>>()
    val listCountry: LiveData<List<CountriesShort>>
        get() = _listCountry

    fun getListCountries(){
        viewModelScope.launch {
            _listCountry.value = getCountriesListUseCase.invoke()
        }
    }

}