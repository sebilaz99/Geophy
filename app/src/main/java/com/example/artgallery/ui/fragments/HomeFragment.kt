package com.example.artgallery.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artgallery.R
import com.example.artgallery.adapter.ContinentAdapter
import com.example.artgallery.adapter.RegionAdapter
import com.example.artgallery.di.RetrofitInstance
import com.example.artgallery.model.ContinentItem
import com.example.artgallery.ui.activities.RegionScreen
import retrofit2.HttpException
import java.io.IOException


class HomeFragment : Fragment(R.layout.fragment_home), AdapterView.OnItemLongClickListener {

    private var list: ArrayList<ContinentItem>? = null

    private lateinit var gv: GridView

    private lateinit var continentAdapter: ContinentAdapter

    private var regionFragment = RegionFragment()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()


        gv = view.findViewById(R.id.gridView)

        list = ArrayList()
        list = populateGV()

        continentAdapter = ContinentAdapter(view.context, list!!)

        gv.adapter = continentAdapter

        gv.onItemLongClickListener = this

        gv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                when (position) {

                    0 -> switchFragment(regionFragment)
                    1 -> Toast.makeText(view?.context, "1", Toast.LENGTH_SHORT).show()
                }
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

    override fun onItemLongClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ): Boolean {
        val list = list!![position]
        Toast.makeText(this.context, list.name, Toast.LENGTH_SHORT).show()
        return true
    }

}