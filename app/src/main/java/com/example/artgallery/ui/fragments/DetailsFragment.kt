package com.example.artgallery.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.artgallery.R

import com.example.artgallery.model.Country
import com.example.artgallery.vm.CountryVM
import de.hdodenhof.circleimageview.CircleImageView
import javax.inject.Inject


class DetailsFragment : Fragment(R.layout.fragment_details) {

    @Inject
    lateinit var vm: CountryVM

    private val args: DetailsFragmentArgs by navArgs()

    private lateinit var country: Country


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

        val flag = view.findViewById<CircleImageView>(R.id.flagIV)
        val coat = view.findViewById<ImageView>(R.id.coatIV)
        val name = view.findViewById<TextView>(R.id.nameTV)
        val capital = view.findViewById<TextView>(R.id.capitalTV)
        val population = view.findViewById<TextView>(R.id.populationTV)
        val area = view.findViewById<TextView>(R.id.areaTV)
        val lanlng = view.findViewById<TextView>(R.id.latlngTV)
        val timezone = view.findViewById<TextView>(R.id.timezoneTV)

        Glide.with(view)
            .load(country.coatOfArms.png)
            .placeholder(R.drawable.ic_baseline_flag_24)
            .into(coat)

        Glide.with(view)
            .load(country.flags.png)
            .placeholder(R.drawable.ic_baseline_flag_24)
            .into(flag)

        name.text = country.name.common
        capital.text = country.capital[0]
        population.text = country.population.toString()
        lanlng.text = country.latlng[0].toString() + ", " + country.latlng[1].toString()
        area.text = country.area.toInt().toString() + " km2"
        if (country.timezones.size > 1) {
            timezone.text = country.timezones[0] + " - " + country.timezones[country.timezones.size - 1]
        }
        else timezone.text = country.timezones[0]
    }


}