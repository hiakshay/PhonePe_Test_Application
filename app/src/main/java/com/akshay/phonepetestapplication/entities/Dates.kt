package com.akshay.phonepetestapplication.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dates(

    @SerializedName("maximum") var maximum: String? = null,
    @SerializedName("minimum") var minimum: String? = null

) : Parcelable