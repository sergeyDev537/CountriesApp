package com.most4dev.countriesapp.data.retrofit

import com.most4dev.countriesapp.domain.entity.CountriesLong
import com.most4dev.countriesapp.domain.entity.CountriesShort
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("all?fields=name,flags")
    suspend fun getShortFieldsList(): Response<List<CountriesShort>>

    @GET("name/{name}?fields=name,flags,region,capital,currencies,timezones")
    suspend fun getLongFieldsItem(
        @Path("name") name: String
    ): Response<List<CountriesLong>>

}