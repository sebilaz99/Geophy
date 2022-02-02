package com.example.artgallery.ui.activities

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.artgallery.MainActivity
import com.example.artgallery.R
import org.w3c.dom.Text

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.AliceBlue)

        val animation = findViewById<LottieAnimationView>(R.id.animationView)
        val txt = findViewById<TextView>(R.id.appNameTV)
        txt.visibility = TextView.INVISIBLE

        animation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                txt.visibility = TextView.VISIBLE
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }
        })

    }
}