package com.example.artgallery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Country(
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val flags: Flags,
    val languages: Languages,
    val latlng: List<Double>,
    val name: Name,
    val population: Int,
    val region: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String> //This' going to be country's ID
) : Parcelable