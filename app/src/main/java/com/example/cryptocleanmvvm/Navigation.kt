package com.example.cryptocleanmvvm

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptocleanmvvm.presentation.Screen
import com.example.cryptocleanmvvm.presentation.coin_list.components.CoinDetailScreen
import com.example.cryptocleanmvvm.presentation.coin_list.components.CoinListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {

        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }

        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }

//        composable(
//            route = Screen.CoinDetailScreen.route + "/{coinId}",
//            arguments = listOf(
//                navArgument("coinId") {
//                    type = NavType.StringType
//                    defaultValue = "1"
//                    nullable = true
//                }
//
//            )
//        ) { entry ->
//            CoinDetailScreen(
////                coinId = entry.arguments?.getString("id")
//            )
//        }
    }
}

