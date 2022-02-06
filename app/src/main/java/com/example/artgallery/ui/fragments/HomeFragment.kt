package com.example.artgallery.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.artgallery.R
import com.example.artgallery.adapter.ContinentAdapter
import com.example.artgallery.model.ContinentItem


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var list: ArrayList<ContinentItem>? = null

    private lateinit var gv: GridView

    private lateinit var continentAdapter: ContinentAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()


        gv = view.findViewById(R.id.gridView)

        list = ArrayList()
        list = populateGV()


        continentAdapter = ContinentAdapter(view.context, list!!)

        gv.adapter = continentAdapter



        gv.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { parent, view, position, id ->
                Toast.makeText(view?.context, list!![position].name, Toast.LENGTH_SHORT).show()
                true
            }


        gv.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val continent = list!![position].name
            val action = HomeFragmentDirections.actionHomeFragmentToGalleryFragment(continent)
            view.findNavController().navigate(action)
        }


        val gitTxt = view.findViewById<TextView>(R.id.githubTV)
        gitTxt.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sebilaz99")))
        }

    }

    private fun switchFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, fragment)?.commit()
    }


    private fun populateGV(): ArrayList<ContinentItem> {

        val list: ArrayList<ContinentItem> = ArrayList()

        list.add(ContinentItem(R.drawable.europe, "Europe"))
        list.add(ContinentItem(R.drawable.americas, "Americas"))
        list.add(ContinentItem(R.drawable.asia, "Asia"))
        list.add(ContinentItem(R.drawable.africa, "Africa"))
        list.add(ContinentItem(R.drawable.oceania, "Oceania"))

        return list
    }


}