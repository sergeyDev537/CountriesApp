package com.most4dev.countriesapp.domain.entity

import com.google.gson.annotations.SerializedName

data class CountriesLong(
    @SerializedName("name")
    val name: String,
    @SerializedName("capital")
    val capital: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("timezones")
    val timezones: List<String>,
    @SerializedName("currencies")
    val currencies: List<Currency>,
    @SerializedName("independent")
    val independent: Boolean
)