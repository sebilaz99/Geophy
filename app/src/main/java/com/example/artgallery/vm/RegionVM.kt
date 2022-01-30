package com.example.artgallery.vm

import android.content.Context
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData
import com.example.artgallery.model.ContinentItem
import com.example.artgallery.repository.RegionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.artgallery.utils.Resource

//@HiltViewModel
//class RegionVM
//@Inject
//constructor(
//    private val regionRepo: RegionRepository,
//    @ApplicationContext
//    private val context: Context
//) : ViewModel() {
//
//
//    val resp: MutableLiveData<Resource<ContinentItem>> = MutableLiveData()
//
////    init {
////        resp = MutableLiveData()
////    }
////
////    fun getEurope() {
////        resp.postValue(Resource.Loading() )
////        viewModelScope.launch {
////            val response = regionRepo.getEurope()
////            resp.postValue(response.isSuccessful)
////        }
////
////    }
//}
