package com.example.cryptocee.feature_crypto_main.presentation.screens.search

import com.example.cryptocee.feature_crypto_main.domain.model.SearchResponse

data class SearchState(
    var loading:Boolean? = false,
    var searchData: SearchResponse? = null,
    var message:String? = null
)
