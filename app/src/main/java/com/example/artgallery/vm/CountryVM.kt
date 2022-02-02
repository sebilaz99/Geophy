package com.example.artgallery.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artgallery.model.Country
import com.example.artgallery.repository.CountryRepository
import com.example.artgallery.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class CountryVM @Inject constructor(private val countryRepository: CountryRepository) :
    ViewModel() {


    private val detailsLiveData = MutableLiveData<Response<Country>>()

    suspend fun getDetails(tld: String) {
        viewModelScope.launch {
            detailsLiveData.postValue(countryRepository.getDetails(tld))
        }

    }

    var countryDetails : LiveData<Response<Country>> = detailsLiveData


}