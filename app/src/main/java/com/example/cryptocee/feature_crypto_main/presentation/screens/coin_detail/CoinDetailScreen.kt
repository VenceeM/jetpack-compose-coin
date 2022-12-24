package com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocee.components.Header
import com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail.components.CoinDetailText
import com.example.cryptocee.util.AppColors


@Composable
fun CoinDetailScreen(coinDetailViewModel: CoinDetailViewModel = hiltViewModel(),navController: NavController){
    val state = coinDetailViewModel.state.value
    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), backgroundColor = AppColors.background_main, topBar = { Header(
        title = "Coin Details",
        navController = navController, isSearch = false, showSearch = false, onSearch = {})}) {
        state.coinDetail?.let{detail ->
            Log.d("COIN_DETAIL", "CoinDetailScreen: ${detail.name}")
            CoinDetailText(detail)
        }
        if (state.loading == true){
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                CircularProgressIndicator()
            }
        }

    }
}
