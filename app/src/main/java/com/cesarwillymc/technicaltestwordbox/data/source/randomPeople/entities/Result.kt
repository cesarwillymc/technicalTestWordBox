package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("cell")
    val cell: String, // 93459862
    @SerializedName("dob")
    val dob: Dob,
    @SerializedName("email")
    val email: String, // tilde.rasmussen@example.com
    @SerializedName("gender")
    val gender: String, // female
    @SerializedName("id")
    val id: Id,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: Name,
    @SerializedName("nat")
    val nat: String, // DK
    @SerializedName("phone")
    val phone: String, // 03375834
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("registered")
    val registered: Registered
)