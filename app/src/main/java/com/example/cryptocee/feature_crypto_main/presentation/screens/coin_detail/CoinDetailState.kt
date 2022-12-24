package com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail

import com.example.cryptocee.feature_crypto_main.domain.model.CoinDetailResponse

data class CoinDetailState(
    var loading:Boolean? = null,
    var coinDetail:CoinDetailResponse? = null,
    var coinDetailSearch: List<CoinDetailResponse>? = null,
    var message:String? = null
)
