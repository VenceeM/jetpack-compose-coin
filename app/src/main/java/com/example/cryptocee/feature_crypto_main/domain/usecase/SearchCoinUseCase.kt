package com.example.cryptocee.feature_crypto_main.domain.usecase

import com.example.cryptocee.feature_crypto_main.domain.model.SearchResponse
import com.example.cryptocee.feature_crypto_main.domain.repository.CoinRepository
import com.example.cryptocee.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke(q:String):Flow<Resource<SearchResponse>> = flow {

        try{
            emit(Resource.Loading())
            val result = coinRepository.searchCoin(q)
            emit(Resource.Success(result))

        }catch (e:Exception){
            emit(Resource.Error(null, message = e.localizedMessage))
        }

    }

}