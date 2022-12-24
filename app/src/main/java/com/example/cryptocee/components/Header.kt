package com.example.cryptocee.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cryptocee.navigation.NavigationItem
import com.example.cryptocee.util.AppColors

@Composable
fun Header(
    title:String = "Home",
    onBackClick:()->Unit = {}, isVisible:Boolean = true,
    navController:NavController,
    showSearch:Boolean = false,
    isSearch:Boolean = false,
    state: MutableState<TextFieldValue>? = null, onSearch:()-> Unit){



    TopAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = AppColors.header_color) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp), verticalAlignment = Alignment.CenterVertically) {

            if(isVisible){
                Icon(modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    },imageVector = Icons.Default.ArrowBack, tint = Color.White, contentDescription = "Arrow back")
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = title, style = MaterialTheme.typography.h6, color = Color.White)

            if(isSearch){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    SearchInput(state = state!!, onSearch = onSearch)
                }
            }else if(showSearch){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    IconButton(onClick = { navController.navigate(NavigationItem.SearchScreen.screenName) }) {
                        Icon(modifier = Modifier.size(30.dp),imageVector = Icons.Default.Search, contentDescription = "Search Icon", tint = Color.White)
                    }
                }
            }


        }
        
    }

}