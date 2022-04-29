package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: Int, // 50
    @SerializedName("seed")
    val seed: String, // 947535423b098d30
    @SerializedName("version")
    val version: String // 1.3
)