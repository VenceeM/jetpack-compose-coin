package com.example.cryptocee.feature_crypto_main.data.repository

import com.example.cryptocee.feature_crypto_main.data.core.CoinApi
import com.example.cryptocee.feature_crypto_main.domain.model.CoinDetailResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponseItem
import com.example.cryptocee.feature_crypto_main.domain.model.SearchResponse
import com.example.cryptocee.feature_crypto_main.domain.repository.CoinRepository
import retrofit2.Response
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api:CoinApi): CoinRepository {

    override suspend fun getAllCoins(): CoinResponse {
        return api.getAllCoins()
    }

    override suspend fun getCoinDetail(coin_id: String): CoinDetailResponse {
        return api.getCoinDetail(coin_id)
    }

    override suspend fun searchCoin(q: String): SearchResponse {
        return api.searchCoin(q)
    }


}