package com.example.cryptocee.feature_crypto_main.data.core

import com.example.cryptocee.feature_crypto_main.domain.model.CoinDetailResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponseItem
import com.example.cryptocee.feature_crypto_main.domain.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET("coins")
    suspend fun getAllCoins(): CoinResponse

    @GET("coins/{coin_id}")
    suspend fun getCoinDetail(@Path("coin_id") coin_id:String): CoinDetailResponse

    @GET("search")
    suspend fun searchCoin(@Query("q") q:String):SearchResponse

}