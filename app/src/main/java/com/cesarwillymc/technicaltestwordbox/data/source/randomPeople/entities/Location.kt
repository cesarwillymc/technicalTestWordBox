package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    val city: String, // Ryslinge
    @SerializedName("country")
    val country: String, // Denmark
)