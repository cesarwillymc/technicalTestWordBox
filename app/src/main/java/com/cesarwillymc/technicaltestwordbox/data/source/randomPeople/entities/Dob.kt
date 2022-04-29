package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("age")
    val age: Int, // 54
    @SerializedName("date")
    val date: String // 1968-12-31T06:12:51.987Z
)