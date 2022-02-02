package com.example.artgallery.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.artgallery.R
import com.example.artgallery.databinding.FragmentDetailsBinding
import com.example.artgallery.model.Country
import com.example.artgallery.vm.CountryVM
import javax.inject.Inject


class DetailsFragment : Fragment(R.layout.fragment_details) {

    @Inject
    lateinit var vm: CountryVM

    private val args: DetailsFragmentArgs by navArgs()

    private lateinit var country : Country

    private var _binding: FragmentDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = super.onCreateView(inflater, container, savedInstanceState)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       country = args.country

        populateUI()


//        vm.countryDetails.observe(viewLifecycleOwner) {
//            when (it.isSuccessful) {
//                vm.countryDetails = it.body()
//            }
//        }
    }

    private fun populateUI() {

        binding.apply {
            Glide.with(coatIV.context)
                .load(country.coatOfArms.png)
                .placeholder(R.drawable.ic_baseline_flag_24)
                .into(coatIV)

            Glide.with(flagIV.context)
                .load(country.flags.png)
                .placeholder(R.drawable.ic_baseline_flag_24)
                .into(flagIV)

            nameTV.text = country.name.official
            capitalTV.text = country.capital[0]
            populationTV.text = country.population.toString()
            areaTV.text = country.area.toString()
            latlngTV.text = country.latlng[0].toString()
            timezoneTV.text = country.timezones.toString()

        }
    }

}