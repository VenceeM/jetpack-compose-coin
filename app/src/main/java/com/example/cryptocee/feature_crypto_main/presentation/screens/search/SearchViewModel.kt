package com.example.cryptocee.feature_crypto_main.presentation.screens.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocee.feature_crypto_main.domain.usecase.SearchCoinUseCase
import com.example.cryptocee.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchCoinUseCase: SearchCoinUseCase):ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state:State<SearchState> = _state

    init {

    }

    fun searchCoin(q:String){
        searchCoinUseCase(q).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = SearchState(loading = false, searchData = result.data)
                }
                is Resource.Error -> {
                    _state.value = SearchState(loading = false, message = result.message)
                }
                is Resource.Loading -> {
                    _state.value = SearchState(loading = true)
                }
            }

        }.launchIn(viewModelScope)
    }

    fun coinsss(q:String) = viewModelScope.launch {
        searchCoinUseCase(q).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = SearchState(loading = false, searchData = result.data)
                }
                is Resource.Error -> {
                    _state.value = SearchState(loading = false, message = result.message)
                }
                is Resource.Loading -> {
                    _state.value = SearchState(loading = true)
                }
            }

        }
    }


}