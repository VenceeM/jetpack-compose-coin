package com.example.cryptocee.feature_crypto_main.presentation.screens.search

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocee.components.Header
import com.example.cryptocee.util.AppColors

@Composable
fun SearchScreen(navController: NavController, searchViewModel: SearchViewModel = hiltViewModel()){

    val state = searchViewModel.state.value

    val searchState = remember {
        mutableStateOf(TextFieldValue(""))
    }


   Scaffold(modifier = Modifier
       .fillMaxWidth()
       .fillMaxHeight(), topBar = { Header(
       navController = navController, title = "",
       isVisible = true, isSearch = true, state = searchState, onSearch = { })}, backgroundColor = AppColors.background_main) {

       searchViewModel.searchCoin(searchState.value.text)
       Log.d("SEARCHDATA", "SearchScreen: $state")

       if(state.loading != true){
           SearchCustomLazyColumn(state = state)
       }else{
           Column(modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
               CircularProgressIndicator()
           }
           Log.d("SEARCHDATA", "SearchScreen: $state")
       }

   }

}
