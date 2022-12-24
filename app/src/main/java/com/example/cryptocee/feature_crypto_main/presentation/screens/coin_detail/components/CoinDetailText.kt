package com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.cryptocee.feature_crypto_main.domain.model.CoinDetailResponse

@Composable
fun CoinDetailText(
    coinDetail:CoinDetailResponse){
    Box(modifier = Modifier.padding(10.dp)){
        Column {
            LazyColumn(contentPadding = PaddingValues(bottom = 50.dp)){
                item{
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        SubcomposeAsyncImage(model = coinDetail.logo,
                            contentDescription = "${coinDetail.symbol}")
                        Spacer(modifier = Modifier.padding(start = 10.dp))
                        Text(text = coinDetail.name, style = MaterialTheme.typography.h5, color = Color.White)
                        Text(text = "(${coinDetail.symbol})", style = MaterialTheme.typography.h5, color = Color.White)
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),horizontalArrangement = Arrangement.End){
                            if(coinDetail.isActive){
                                Text(text = "active", style = MaterialTheme.typography.body1,color = Color(
                                    100,
                                    129,
                                    209,
                                    255
                                ))
                            }
                            else{
                                Text(text = "inactive", style = MaterialTheme.typography.body1,color = Color(
                                    226,
                                    127,
                                    127,
                                    255
                                ))

                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = coinDetail.description, style = MaterialTheme.typography.body1,color = Color.White)

                    }
                }
            }

        }
    }
}
