package com.example.artgallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.artgallery.ui.fragments.HomeFragment
import com.example.artgallery.ui.fragments.RegionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.AliceBlue)

        val homeFragment = RegionFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, homeFragment).commit()
    }
}