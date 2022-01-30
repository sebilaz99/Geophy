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
        val departments = apiService.getEurope()
        departments
    }


}