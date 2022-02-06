package com.example.artgallery.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.example.artgallery.R
import com.example.artgallery.adapter.RegionAdapter
import com.example.artgallery.di.RetrofitInstance
import com.example.artgallery.model.ContinentInfo
import com.example.artgallery.model.ContinentItem
import com.example.artgallery.network.ApiService
import com.example.artgallery.repository.RegionRepository
import com.example.artgallery.vm.RegionVM
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.builders.ServiceComponentBuilder
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

    val detailsFragment = DetailsFragment()

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

        val regionName = view.findViewById<TextView>(R.id.textView)
        val population = view.findViewById<TextView>(R.id.population)
        val area = view.findViewById<TextView>(R.id.area)
        val countries = view.findViewById<TextView>(R.id.countries)


        val infos: ArrayList<ContinentInfo> = ArrayList()
        infos.add(ContinentInfo("746,419,440", "10,180,000", 50))
        infos.add(ContinentInfo("964,920,000", "42,549,000", 35))
        infos.add(ContinentInfo("4,560,667,108", "44,579,000", 49))
        infos.add(ContinentInfo("1,275,920,972", "30,370,000", 56))
        infos.add(ContinentInfo("41,570,842", "8,525,989", 14))

        val region = args.continent

        regionName.text = region

        val images: ArrayList<String> = ArrayList()
        images.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Europe_orthographic_Caucasus_Urals_boundary_%28with_borders%29.svg/800px-Europe_orthographic_Caucasus_Urals_boundary_%28with_borders%29.svg.png")
        images.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Asia_%28orthographic_projection%29.svg/800px-Asia_%28orthographic_projection%29.svg.png")
        images.add("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Americas_%28orthographic_projection%29.svg/800px-Americas_%28orthographic_projection%29.svg.png")
        images.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/800px-Africa_%28orthographic_projection%29.svg.png")
        images.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Oceania_%28orthographic_projection%29.svg/800px-Oceania_%28orthographic_projection%29.svg.png")


        when (region) {
            "Europe" -> vm.europeResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
                setImage(images[0])
                population.text = infos[0].population
                area.text = infos[0].area
                countries.text = infos[0].countries.toString()
            }

            "Asia" -> vm.asiaResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
                setImage(images[1])
                population.text = infos[1].population
                area.text = infos[1].area
                countries.text = infos[1].countries.toString()
            }

            "Americas" -> vm.americasResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
                setImage(images[2])
                population.text = infos[2].population
                area.text = infos[2].area
                countries.text = infos[2].countries.toString()
            }

            "Africa" -> vm.africaResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
                setImage(images[3])
                population.text = infos[3].population
                area.text = infos[3].area
                countries.text = infos[3].countries.toString()
            }

            "Oceania" -> vm.oceaniaResp.observe(requireActivity()) { response ->
                regionAdapter.countries = response
                setImage(images[4])
                population.text = infos[4].population
                area.text = infos[4].area
                countries.text = infos[4].countries.toString()
            }
        }

    }

    private fun setupRV() {
        regionAdapter = RegionAdapter()
        rv.adapter = regionAdapter
        rv.layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setImage(link: String) {
        val map = view?.findViewById<ImageView>(R.id.regionOnMapIV)

        Glide.with(this)
            .load(link)
            .placeholder(R.drawable.ic_baseline_map_24)
            .into(map!!)
    }


//    private fun setupSearchView() {
//        val sv = view?.findViewById<SearchView>(R.id.searchView)
//
//        sv?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                val response = query?.let { vm.getByName(it) }
//                response.
//            }
//
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }

}