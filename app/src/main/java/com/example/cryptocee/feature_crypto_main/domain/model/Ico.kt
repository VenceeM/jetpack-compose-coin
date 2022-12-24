package com.example.cryptocee.feature_crypto_main.domain.model


import com.google.gson.annotations.SerializedName

data class Ico(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rev")
    val rev: Int,
    @SerializedName("symbol")
    val symbol: String
)