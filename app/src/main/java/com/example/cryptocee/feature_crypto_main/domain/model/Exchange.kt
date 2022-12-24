package com.example.cryptocee.feature_crypto_main.domain.model


import com.google.gson.annotations.SerializedName

data class Exchange(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("rev")
    val rev: Int
)