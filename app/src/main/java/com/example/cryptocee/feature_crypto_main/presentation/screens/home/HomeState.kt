package com.example.cryptocee.feature_crypto_main.presentation.screens.home

import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponseItem
import retrofit2.Response

data class HomeState(
    var loading:Boolean? = null,
    var coins:List<CoinResponseItem>? = null,
    var message:String? = null
)
