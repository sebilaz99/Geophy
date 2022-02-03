package com.example.artgallery.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.artgallery.R
import com.example.artgallery.adapter.RegionAdapter
import com.example.artgallery.di.RetrofitInstance
import com.example.artgallery.vm.RegionVM
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class RegionFragment : Fragment(R.layout.fragment_region) {

    private lateinit var regionAdapter: RegionAdapter

    private lateinit var rv: RecyclerView

    val vm: RegionVM by viewModels()

    val args: RegionFragmentArgs by navArgs()


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

        val animation = view.findViewById<LottieAnimationView>(R.id.animationView)

        animation.visibility = LottieAnimationView.VISIBLE

        setupRV()

        val regionName = view.findViewById<TextView>(R.id.textView)

        val region = args.continent

        regionName.text = region


        when (region) {
            "Europe" -> vm.europeResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
            }

            "Asia" -> vm.asiaResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
            }

            "Americas" -> vm.americasResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
            }

            "Africa" -> vm.africaResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
            }

            "Oceania" -> vm.oceaniaResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
            }
        }


        animation.visibility = LottieAnimationView.GONE

    }

    private fun setupRV() {
        regionAdapter = RegionAdapter()
        rv.adapter = regionAdapter
        rv.layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.HORIZONTAL, false)
    }



}