package com.example.Navegation.Screen

import ScreenB
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.Screen.ScreenA

@Preview(showBackground = true)
@Composable
fun navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ScreenA") {
        composable("ScreenA") {
            ScreenA(navController)
        }
        composable("ScreenB") {
            ScreenB(navController)
        }
    }
}

