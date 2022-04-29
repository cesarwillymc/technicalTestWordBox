package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("age")
    val age: Int, // 15
    @SerializedName("date")
    val date: String // 2007-08-28T20:33:23.331Z
)