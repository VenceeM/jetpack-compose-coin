package com.example.cryptocee.navigation

sealed class NavigationItem(var screenName:String){
    object HomeScreen: NavigationItem("home_screen")
    object CoinDetailScreen : NavigationItem("detail_screen")
    object SearchScreen: NavigationItem("search_screen")
}
