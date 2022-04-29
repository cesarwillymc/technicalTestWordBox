package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    val name: String, // CPR
    @SerializedName("value")
    val value: String // 311268-8770
)