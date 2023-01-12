package com.most4dev.countriesapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.most4dev.countriesapp.data.CountriesRepositoryImpl
import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.usecases.GetCountryUseCase
import kotlinx.coroutines.launch

class CountryItemViewModel: ViewModel() {

    private var repository = CountriesRepositoryImpl

    private val getCountryUseCase = GetCountryUseCase(repository)

    private var _itemCountry = MutableLiveData<CountriesLong>()
    val itemCountry: LiveData<CountriesLong>
        get() = _itemCountry

    fun getItemCountry(name: String){
        viewModelScope.launch {
            _itemCountry.value = getCountryUseCase.invoke(name)
        }
    }

}