package com.example.artgallery.repository

import com.example.artgallery.model.Country
import com.example.artgallery.network.ApiService
import com.example.artgallery.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CountryRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getDetails(tld: String): Response<Country> = withContext(Dispatchers.IO) {
        val response = apiService.getDetails(tld)
        response
    }

}