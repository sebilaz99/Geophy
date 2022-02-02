package com.example.artgallery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoatOfArms(
    val png: String,
    val svg: String
) : Parcelable