package com.most4dev.countriesapp.domain.entity

data class CountriesLong(
    val capital: String,
    val currencies: List<Currency>,
    val flags: List<String>,
    val name: String,
    val region: String,
    val timezones: List<String>
)