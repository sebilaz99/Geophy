package com.example.artgallery.vm

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData
import com.example.artgallery.model.ContinentItem
import com.example.artgallery.model.Country
import com.example.artgallery.repository.RegionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.artgallery.utils.Resource

@HiltViewModel
class RegionVM
@Inject
constructor(
    private val regionRepo: RegionRepository
) : ViewModel() {


    val resp: MutableLiveData<List<Country>> = MutableLiveData()

    val countryResp: LiveData<List<Country>>
        get() = resp

    init {
        getEurope()
    }

    fun getEurope() {
        viewModelScope.launch {
            regionRepo.getEurope().let { response ->
                if (response.isSuccessful) {
                    resp.postValue(response.body())
                } else {
                    Log.d("REG", "getEurope: ${response.code()}")
                }
            }

        }

    }

}
