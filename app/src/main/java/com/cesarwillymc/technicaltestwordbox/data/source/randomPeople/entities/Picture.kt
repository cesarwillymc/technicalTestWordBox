package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("large")
    val large: String, // https://randomuser.me/api/portraits/women/96.jpg
    @SerializedName("medium")
    val medium: String, // https://randomuser.me/api/portraits/med/women/96.jpg
    @SerializedName("thumbnail")
    val thumbnail: String // https://randomuser.me/api/portraits/thumb/women/96.jpg
)