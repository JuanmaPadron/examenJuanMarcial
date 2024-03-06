package com.example.examenjuanmarcial.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenjuanmarcial.R

enum class Home(val title : Int) {
    Login(title = R.string.login),
    Screen2(title = R.string.screen2)
}
@Composable
fun MyHome(navController: NavHostController = rememberNavController()) {
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Home.Login.name,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = Home.Login.name) {
                Login(onContinueClicked = { navController.navigate(Home.Screen2.name) })
            }
            composable(route = Home.Screen2.name) {
                Screen2(backButton = { navController.navigate(Home.Login.name) })
            }
        }
    }
}