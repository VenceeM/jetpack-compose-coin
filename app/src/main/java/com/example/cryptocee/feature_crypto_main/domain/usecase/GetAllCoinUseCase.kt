package com.example.cryptocee.feature_crypto_main.domain.usecase

import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponse
import com.example.cryptocee.feature_crypto_main.domain.model.CoinResponseItem
import com.example.cryptocee.feature_crypto_main.domain.repository.CoinRepository
import com.example.cryptocee.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class GetAllCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {


    operator fun invoke():Flow<Resource<CoinResponse>> = flow {
        try{
            emit(Resource.Loading())
            val result = coinRepository.getAllCoins()
            emit(Resource.Success(result))

        }catch (e:Exception){
            emit(Resource.Error(null,e.localizedMessage))
        }
    }

}