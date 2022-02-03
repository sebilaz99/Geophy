package com.example.artgallery.repository

import com.example.artgallery.model.ContinentItem
import com.example.artgallery.model.Country
import com.example.artgallery.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegionRepository
@Inject
constructor(private val apiService: ApiService) {


    suspend fun getEurope(): Response<List<Country>> = withContext(Dispatchers.IO) {
        val countries = apiService.getEurope()
        countries
    }

    suspend fun getAmericas(): Response<List<Country>> = withContext(Dispatchers.IO) {
        val countries = apiService.getAmericas()
        countries
    }

    suspend fun getAsia(): Response<List<Country>> = withContext(Dispatchers.IO) {
        val countries = apiService.getAsia()
        countries
    }

    suspend fun getAfrica(): Response<List<Country>> = withContext(Dispatchers.IO) {
        val countries = apiService.getAfrica()
        countries
    }

    suspend fun getOceania(): Response<List<Country>> = withContext(Dispatchers.IO) {
        val countries = apiService.getOceania()
        countries
    }

}