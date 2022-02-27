package com.akshay.phonepetestapplication.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieData(

    @SerializedName("dates") var dates: Dates? = Dates(),
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<MovieResult> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null

) : Parcelable