package com.example.cryptocleanmvvm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptocleanmvvm.presentation.coin_detail.CoinDetailFragment
import com.example.cryptocleanmvvm.presentation.coin_detail.CoinDetailScreen
import com.example.cryptocleanmvvm.presentation.coin_detail.CoinDetailState
import com.example.cryptocleanmvvm.presentation.coin_list.components.CoinListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {

        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }

        composable(
            route = Screen.DetailScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = "1"
                    nullable = true
                }

            )
        ) { entry ->
//                CoinDetailScreen(  navController = navController, coinId = 1 )
            CoinDetailScreen(
                navController = navController,
                coinId = entry.arguments?.getString("id")
            )
        }
    }
}
