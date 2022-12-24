package com.example.cryptocee.components

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text:String? = "Bitcoin",
    color: Long = 0xFFFFFFFF,
    fontWeight: FontWeight = FontWeight.Normal,
){
    Text(text = text!!, style = TextStyle(color = Color.Black, fontWeight = fontWeight, fontSize = 20.sp))
}