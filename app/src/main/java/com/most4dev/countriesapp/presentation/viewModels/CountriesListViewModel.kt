package com.most4dev.countriesapp.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.most4dev.countriesapp.data.CountriesRepositoryImpl
import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.usecases.GetCountriesListUseCase
import com.most4dev.countriesapp.domain.usecases.GetCountryUseCase
import kotlinx.coroutines.launch

class CountriesListViewModel : ViewModel() {

    private var repository = CountriesRepositoryImpl

    private val getCountriesListUseCase = GetCountriesListUseCase(repository)
    private val getCountryUseCase = GetCountryUseCase(repository)

    private var _listCountry = MutableLiveData<List<CountriesLong>>()
    val listCountry: LiveData<List<CountriesLong>>
        get() = _listCountry

    private var _itemCountry = MutableLiveData<CountriesLong>()
    val itemCountry: LiveData<CountriesLong>
        get() = _itemCountry

    private var _errorLoadData = MutableLiveData<String>()
    val errorLoadData: LiveData<String>
        get() = _errorLoadData

    private var _errorLoadItem = MutableLiveData<String>()
    val errorLoadItem: LiveData<String>
        get() = _errorLoadItem

    init {
        getListCountries()
    }

    fun getListCountries() {
        Log.d("TAGING", "getListCountries")
        viewModelScope.launch {
            try {
                _listCountry.value = getCountriesListUseCase.invoke()
            } catch (e: Exception) {
                _errorLoadData.value = e.message
            }
        }
    }

    fun getItemCountry(name: String){
        try {
            _itemCountry.value = getCountryUseCase.invoke(name)
        }
        catch (e: Exception){
            _errorLoadItem.value = e.message
        }

    }

    fun clearErrorLoadList() {
        _errorLoadData.value = ""
    }

}