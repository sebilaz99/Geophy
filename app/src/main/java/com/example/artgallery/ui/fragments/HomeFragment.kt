package com.example.artgallery.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.artgallery.R
import com.example.artgallery.adapter.ContinentAdapter
import com.example.artgallery.model.ContinentItem


class HomeFragment : Fragment(R.layout.fragment_home) {

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

        val bg = view.findViewById<ConstraintLayout>(R.id.homeBackground)

        val images = intArrayOf(
            R.drawable.europe_img,
            R.drawable.americas_img,
            R.drawable.asia_img,
            R.drawable.africa_img,
            R.drawable.oceania_img
        )


        val layout = view.findViewById<RelativeLayout>(R.id.relativeLayout)
        gv.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { parent, view, position, id ->
                layout.apply {
                    setBackgroundResource(images[position])
                    Toast.makeText(view?.context, list!![position].name, Toast.LENGTH_SHORT).show()
                }
                true
            }

        gv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                when (position) {
                    0 -> switchFragment(regionFragment)
                    1 -> Toast.makeText(view?.context, "1", Toast.LENGTH_SHORT).show()
                }
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