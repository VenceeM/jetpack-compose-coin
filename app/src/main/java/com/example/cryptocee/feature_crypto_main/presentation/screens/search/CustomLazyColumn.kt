package com.example.cryptocee.feature_crypto_main.presentation.screens.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cryptocee.feature_crypto_main.domain.model.Currency
import com.example.cryptocee.navigation.bottom_navigation.BottomNavigationItem
import com.example.cryptocee.util.AppColors

@Composable
fun SearchCustomLazyColumn(modifier: Modifier = Modifier,state:SearchState? =null, navController: NavController = rememberNavController()){
    Log.d("TESTINGAPI", "SearchCustomLazyColumn: $state")

    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), backgroundColor = AppColors.background_main) {


        LazyColumn(contentPadding = PaddingValues(bottom = 70.dp)){
            state?.searchData?.currencies.let { data ->
                if(data != null){
                    items(data){ item ->
                        RowItem(item = item){
                            navController.navigate(BottomNavigationItem.CoinDetail.routeName +"/${item.id}")
                            Log.d("IDCOIN", BottomNavigationItem.CoinDetail.routeName +"/${item.id}")
                        }
                    }
                }

            }


        }
        if(state?.message != null){
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Please check your internet connection", style = MaterialTheme.typography.h6)
            }
        }
        
        if(state?.loading == true){
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }



    }


}

@Preview
@Composable
fun RowItem(
    modifier: Modifier = Modifier,
    item: Currency? = null,
    is_active:String = "active",
    onClick:() -> Unit = {}){
    Scaffold(modifier = modifier
        .fillMaxWidth()
        .padding(top = 10.dp, end = 10.dp, start = 10.dp)
        .clip(RoundedCornerShape(topStart = 20.dp, bottomEnd = 15.dp))
        .height(70.dp)
        .clickable { onClick.invoke() }, backgroundColor = Color.DarkGray)
    {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp), verticalArrangement = Arrangement.Center) {
            Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {

                RowText(item?.name + "(${item?.symbol})", style = MaterialTheme.typography.h6, color = Color.White)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                    if (item != null) {
                        if(item?.isActive){
                            RowText("Active", style = MaterialTheme.typography.subtitle2, color = Color(
                                100,
                                129,
                                209,
                                255
                            )
                            )
                        }else{
                            RowText("Inactive", style = MaterialTheme.typography.subtitle2, color = Color(
                                226,
                                127,
                                127,
                                255
                            )
                            )
                        }
                    }
                }


            }

        }
    }

}

@Preview
@Composable
fun RowText(text:String = "Bitcoin", style:TextStyle = MaterialTheme.typography.h6, color:Color = Color.Blue){
    Text(text = text, style = style, maxLines = 2, overflow = TextOverflow.Ellipsis, color = color)
}