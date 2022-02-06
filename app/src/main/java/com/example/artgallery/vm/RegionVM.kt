package com.example.artgallery.vm

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide.init
import com.example.artgallery.model.ContinentItem
import com.example.artgallery.model.Country
import com.example.artgallery.repository.RegionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.artgallery.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@HiltViewModel
class RegionVM
@Inject
constructor(
    private val regionRepo: RegionRepository
) : ViewModel() {


    val europeResp: MutableLiveData<List<Country>> = MutableLiveData()
    val americasResp: MutableLiveData<List<Country>> = MutableLiveData()
    val asiaResp: MutableLiveData<List<Country>> = MutableLiveData()
    val africaResp: MutableLiveData<List<Country>> = MutableLiveData()
    val oceaniaResp: MutableLiveData<List<Country>> = MutableLiveData()

    val queryResp: MutableLiveData<List<Country>> = MutableLiveData()

    init {
        getEurope()
        getAmericas()
        getAsia()
        getAfrica()
        getOceania()
    }


    fun getEurope() {
        viewModelScope.launch {
            regionRepo.getEurope().let { response ->
                if (response.isSuccessful) {
                    europeResp.postValue(response.body())
                } else {
                    Log.d("REG", "getEurope: ${response.code()}")
                }
            }
        }
    }

    fun getAmericas() {
        viewModelScope.launch {
            regionRepo.getAmericas().let { response ->
                if (response.isSuccessful) {
                    americasResp.postValue(response.body())
                } else {
                    Log.d("REG", "getAmericas: ${response.code()}")
                }
            }
        }
    }

    private fun getAsia() {
        viewModelScope.launch {
            regionRepo.getAsia().let { response ->
                if (response.isSuccessful) {
                    asiaResp.postValue(response.body())
                } else {
                    Log.d("REG", "getAsia: ${response.code()}")
                }
            }
        }
    }

    private fun getAfrica() {
        viewModelScope.launch {
            regionRepo.getAfrica().let { response ->
                if (response.isSuccessful) {
                    africaResp.postValue(response.body())
                } else {
                    Log.d("REG", "getAfrica: ${response.code()}")
                }
            }
        }
    }

    private fun getOceania() {
        viewModelScope.launch {
            regionRepo.getOceania().let { response ->
                if (response.isSuccessful) {
                    oceaniaResp.postValue(response.body())
                } else {
                    Log.d("REG", "getOceania: ${response.code()}")
                }
            }
        }
    }


}
