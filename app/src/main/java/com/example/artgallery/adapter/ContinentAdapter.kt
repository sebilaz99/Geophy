package com.example.artgallery.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.artgallery.R
import com.example.artgallery.model.ContinentItem
import com.example.artgallery.ui.fragments.RegionFragment

class ContinentAdapter(var context: Context, var continentList: ArrayList<ContinentItem>) :
    BaseAdapter() {

    override fun getCount(): Int {
        return continentList.size
    }

    override fun getItem(position: Int): Any {
        return continentList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = View.inflate(context, R.layout.department_item, null)
        val image = view.findViewById<ImageView>(R.id.departmentImageView)
        val name = view.findViewById<TextView>(R.id.departmentTextView)

        val continent = continentList[position]
        image.setImageResource(continent.image)
        name.text = continent.name



        return view
    }
}