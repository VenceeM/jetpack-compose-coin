package com.example.cryptocee.feature_crypto_main.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocee.feature_crypto_main.domain.usecase.GetAllCoinUseCase
import com.example.cryptocee.feature_crypto_main.domain.usecase.GetCoinDetailUseCase
import com.example.cryptocee.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCoinUseCase: GetAllCoinUseCase,
    private val getCoinDetailUseCase:GetCoinDetailUseCase):ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state:State<HomeState> = _state

    init {
        getAllCoins()
    }

    fun getAllCoins(){
        getAllCoinUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = HomeState(coins = result.data)
                }
                is Resource.Error -> {
                    _state.value = HomeState(message = result.message)
                    Log.d("COINS", "getAllCoins: ${result.message}")
                }
                is Resource.Loading -> {
                    _state.value = HomeState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}