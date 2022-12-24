package com.example.cryptocee.feature_crypto_main.domain.usecase

import com.example.cryptocee.feature_crypto_main.domain.model.CoinDetailResponse
import com.example.cryptocee.feature_crypto_main.domain.repository.CoinRepository
import com.example.cryptocee.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coin_id:String):Flow<Resource<CoinDetailResponse>> = flow {

        try{
            emit(Resource.Loading())
            val result = repository.getCoinDetail(coin_id)
            emit(Resource.Success(result))

        }catch (e:Exception){
            emit(Resource.Error(message = e.localizedMessage))
        }

    }

}