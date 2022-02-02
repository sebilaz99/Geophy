package com.example.artgallery.network

import com.example.artgallery.model.Country
import dagger.Binds
import dagger.Module
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


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

    @GET("alpha/{tld}")
    suspend fun getDetails(@Path("alpha") tld: String): Response<Country>

}