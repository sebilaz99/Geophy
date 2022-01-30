package com.example.artgallery.network

import com.example.artgallery.model.ContinentItem
import com.example.artgallery.model.Country
import com.example.artgallery.model.CountryItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("region/europe")
    suspend fun getEurope(): Response<List<Country>>

    @GET("region/asia")
    suspend fun getAsia(): Response<List<Country>>

    @GET("region/africa")
    suspend fun getAfrica(): Response<List<Country>>

    @GET("region/americas")
    suspend fun getAmericas(): Response<List<Country>>

    @GET("region/oceania")
    suspend fun getOceania(): Response<List<Country>>

//    @GET("alpha/{tld}")
//    suspend fun getCountry(@Path("alpha") tld: String): Response<Country>

}