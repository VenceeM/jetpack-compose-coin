package com.example.cryptocee.feature_crypto_main.domain.model


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("currencies")
    val currencies: List<Currency>,
    @SerializedName("exchanges")
    val exchanges: List<Exchange>,
    @SerializedName("icos")
    val icos: List<Ico>,
    @SerializedName("people")
    val people: List<People>,
    @SerializedName("tags")
    val tags: List<Any>
)