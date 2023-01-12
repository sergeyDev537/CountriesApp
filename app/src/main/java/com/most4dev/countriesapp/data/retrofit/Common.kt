package com.most4dev.countriesapp.data.retrofit

object Common {
    private const val BASE_URL = "https://restcountries.com/v2/"
    val apiInterface: ApiInterface
        get() = RetrofitClient.getClient(BASE_URL).create(ApiInterface::class.java)
}