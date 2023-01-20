package com.most4dev.countriesapp.data.retrofit

import com.most4dev.countriesapp.domain.entity.CountriesLong
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("all?fields=name,flags,region,capital,currencies,timezones")
    suspend fun getShortFieldsList(): Response<List<CountriesLong>>

}