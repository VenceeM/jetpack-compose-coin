package com.example.cryptocee.navigation.bottom_navigation

import com.example.cryptocee.R

sealed class BottomNavigationItem(var title:String,var icon:Int?,var routeName:String){
    object Home: BottomNavigationItem("Home", R.drawable.ic_currency_bitcoin_24,"home_screen")
    object CoinDetail: BottomNavigationItem("Coin Detail", R.drawable.ic_currency_bitcoin_24,"detail_screen")
}
