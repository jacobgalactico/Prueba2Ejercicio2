package com.example.prueba2ejercicio2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val name: String,
    val description: String,
    val address: String,
    val price: String,
    val date: String
) : Parcelable
