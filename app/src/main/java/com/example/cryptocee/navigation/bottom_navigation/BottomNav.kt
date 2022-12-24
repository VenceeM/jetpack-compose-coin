package com.example.cryptocee.navigation.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavController){
    val screens = listOf(
        BottomNavigationItem.Home
    )

    BottomNavigation(backgroundColor = Color.DarkGray) {

        val navbackStackEntry by navController.currentBackStackEntryAsState()
        val current = navbackStackEntry?.destination?.route

        screens.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon!!), contentDescription = "${item.routeName} icon")},
                selected = current == item.routeName,
                onClick = {
                    navController.navigate(item.routeName)
                })
        }
    }

}