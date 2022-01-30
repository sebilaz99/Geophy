package com.example.artgallery.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artgallery.R
import com.example.artgallery.adapter.RegionAdapter
import com.example.artgallery.di.AppModule
import com.example.artgallery.di.RetrofitInstance
import com.example.artgallery.network.ApiService
import retrofit2.HttpException
import java.io.IOException


class RegionFragment : Fragment(R.layout.fragment_region) {

    private lateinit var regionAdapter: RegionAdapter

    private lateinit var rv: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = super.onCreateView(inflater, container, savedInstanceState)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = view.findViewById(R.id.countriesRV)

        setupRV()

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getEurope()
            } catch (e: IOException) {
                Log.e("Region", "IO")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e("Region", "HTTP")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                regionAdapter.countries = response.body()!!
            }
            else {
                Log.e("Region", "Unsuccessful response")
            }
        }
    }

    private fun setupRV() {
        regionAdapter = RegionAdapter()
        rv.adapter = regionAdapter
        rv.layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.HORIZONTAL, false)
    }
}