package com.most4dev.countriesapp.domain.entity

import com.google.gson.annotations.SerializedName

data class CountriesShort(
    @SerializedName("name")
    val name: String,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("independent")
    val independent: Boolean
)