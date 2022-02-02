package com.example.artgallery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    val common: String,
      val official: String
) : Parcelable