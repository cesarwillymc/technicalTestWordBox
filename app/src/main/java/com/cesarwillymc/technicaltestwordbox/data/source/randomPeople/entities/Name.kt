package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("first")
    val first: String, // Tilde
    @SerializedName("last")
    val last: String, // Rasmussen
    @SerializedName("title")
    val title: String // Miss
)