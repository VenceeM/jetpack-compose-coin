package com.example.cryptocee.feature_crypto_main.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocee.components.CustomLazyColumn
import com.example.cryptocee.components.Header

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel(), navController: NavController){

    val text = remember {
        mutableStateOf(TextFieldValue(""))
    }

    Scaffold(topBar = {Header(navController = navController, isVisible = false, showSearch = true, onSearch = {})}) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {

            CustomLazyColumn(navController = navController, homeViewModel = homeViewModel)
        }


    }
}