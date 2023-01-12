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

    private var _errorLoadData = MutableLiveData<String>()
    val errorLoadData: LiveData<String>
        get() = _errorLoadData



    fun getListCountries(){
        viewModelScope.launch {
            try {
                _listCountry.value = getCountriesListUseCase.invoke()
            }catch (e: Exception){
                _errorLoadData.value = e.message
            }
        }
    }

    fun clearErrorLoadList(){
        _errorLoadData.value = ""
    }

}