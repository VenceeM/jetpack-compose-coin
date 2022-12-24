package com.example.cryptocee.feature_crypto_main.domain.model


import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("teams_count")
    val teamsCount: Int
)