package com.example.cryptocee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocee.components.Header
import com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail.CoinDetailScreen
import com.example.cryptocee.feature_crypto_main.presentation.screens.coin_detail.CoinDetailViewModel
import com.example.cryptocee.feature_crypto_main.presentation.screens.home.HomeScreen
import com.example.cryptocee.feature_crypto_main.presentation.screens.home.HomeViewModel
import com.example.cryptocee.navigation.Navigation
import com.example.cryptocee.navigation.NavigationItem
import com.example.cryptocee.navigation.bottom_navigation.BottomNav
import com.example.cryptocee.navigation.bottom_navigation.BottomNavigationItem
import com.example.cryptocee.ui.theme.CryptoceeTheme
import com.example.cryptocee.util.AppColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoceeTheme {
                val navController = rememberNavController()

                MyApp(navController = navController)
            }
        }
    }
}

@Composable
fun MyApp(navController: NavHostController) {

    Scaffold(bottomBar = { BottomNav(navController = navController)}, backgroundColor = AppColors.background_main) {
        Navigation(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoceeTheme {
       
    }
}