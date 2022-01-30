package com.example.artgallery

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.artgallery.databinding.ActivityMainBinding
import com.example.artgallery.ui.fragments.DetailsFragment
import com.example.artgallery.ui.fragments.HomeFragment
import com.example.artgallery.ui.fragments.RegionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = DetailsFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, homeFragment).commit()
    }
}