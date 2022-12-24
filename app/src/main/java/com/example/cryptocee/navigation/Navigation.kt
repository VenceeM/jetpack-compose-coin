package com.example.cryptocee.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail.CoinDetailScreen
import com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail.CoinDetailViewModel
import com.example.cryptocee.feature_crypto_main.presentation.screens.home.HomeScreen
import com.example.cryptocee.feature_crypto_main.presentation.screens.home.HomeViewModel
import com.example.cryptocee.feature_crypto_main.presentation.screens.search.SearchScreen
import com.example.cryptocee.navigation.bottom_navigation.BottomNavigationItem


@Composable
fun Navigation(navController:NavHostController){

    NavHost(navController = navController, startDestination = BottomNavigationItem.Home.routeName){
        composable(route = BottomNavigationItem.Home.routeName){
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavigationItem.CoinDetail.routeName + "/{coin_id}"){
            CoinDetailScreen(navController = navController)
        }
        composable(route = NavigationItem.SearchScreen.screenName){
            SearchScreen(navController = navController)
        }
    }

}