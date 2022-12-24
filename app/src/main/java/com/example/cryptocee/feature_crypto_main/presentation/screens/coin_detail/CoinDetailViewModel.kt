package com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocee.feature_crypto_main.domain.usecase.GetCoinDetailUseCase
import com.example.cryptocee.util.Constant
import com.example.cryptocee.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle):ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state:State<CoinDetailState> = _state

    init {
        val coin_id = savedStateHandle.get<String>(Constant.PARAM_ID)
        Log.d("COIN_DETAIL", "Test: $coin_id")
        savedStateHandle.get<String>(Constant.PARAM_ID)?.let{coin_id ->
            Log.d("COIN_DETAIL", "Test: $coin_id")
            getCoinDetail(coin_id = coin_id)
        }
    }

    fun getCoinDetail(coin_id:String){
        getCoinDetailUseCase(coin_id).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinDetail = result.data)
                    Log.d("COIN_DETAIL", "getCoinDetail: ${result.data}")
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(message = result.message)
                    Log.d("COIN_DETAIL", "getCoinDetail: ${result.message}")

                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(loading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


}