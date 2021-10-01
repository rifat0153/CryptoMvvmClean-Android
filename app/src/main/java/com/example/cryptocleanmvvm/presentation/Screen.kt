package com.example.cryptocleanmvvm.presentation

sealed class Screen(val route: String) {
    object  CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_screen")

    fun withArgs(vararg  args: String) : String {
        return  buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
