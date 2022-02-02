package com.example.artgallery.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
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


class RegionFragment : Fragment(R.layout.fragment_region) {

    private lateinit var regionAdapter: RegionAdapter

    private lateinit var rv: RecyclerView

    @Inject
    lateinit var vm: RegionVM


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

        vm.countryResp.observe(requireActivity(), { response ->
            regionAdapter.countries = response
        })

        animation.visibility = LottieAnimationView.INVISIBLE


        val backBtn = view.findViewById<AppCompatButton>(R.id.backButton)

        backBtn?.setOnClickListener {
            switchFragment(HomeFragment())
        }

    }

    private fun setupRV() {
        regionAdapter = RegionAdapter()
        rv.adapter = regionAdapter
        rv.layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.HORIZONTAL, false)
    }


    private fun switchFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, fragment)?.commit()
    }
}