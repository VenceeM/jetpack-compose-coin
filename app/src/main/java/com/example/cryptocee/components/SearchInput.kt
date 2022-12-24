package com.example.cryptocee.components

import android.util.Log
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptocee.feature_crypto_main.presentation.screens.search.SearchViewModel
import com.example.cryptocee.util.AppColors


@Composable
fun SearchInput(modifier: Modifier = Modifier, state:MutableState<TextFieldValue>, onSearch: () -> Unit){

    Surface(modifier = Modifier
        .fillMaxWidth(),color = AppColors.background_main) {
        CustomTextField(state = state, onSearch = onSearch)
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(state: MutableState<TextFieldValue>,onSearch:()->Unit = {}){
    val keyBoardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember {
        FocusRequester()
    }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .focusRequester(focusRequester),
        value = state.value, onValueChange = {value -> state.value = value},
        placeholder = { Text(text = "eg:bitcoin | btc", color = Color.DarkGray) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
            )
        }, colors = TextFieldDefaults.textFieldColors(textColor = Color.White,backgroundColor = AppColors.header_color, focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),

        keyboardActions = KeyboardActions(onSearch = {
            keyBoardController?.hide()
            onSearch()
        }), keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search), shape = RectangleShape
    )
    
    LaunchedEffect(Unit){
        focusRequester.requestFocus()
    }
}