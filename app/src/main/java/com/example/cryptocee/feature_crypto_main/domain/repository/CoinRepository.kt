package com.example.cryptocee.feature_crypto_main.domain.repository

import com.example.cryptocee.feature_crypto_main.domain.model.CoinDetailResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponseItem
import com.example.cryptocee.feature_crypto_main.domain.model.SearchResponse
import retrofit2.Response

interface CoinRepository {

    suspend fun getAllCoins():CoinResponse
    suspend fun getCoinDetail(coin_id:String):CoinDetailResponse
    suspend fun searchCoin(q:String):SearchResponse

}