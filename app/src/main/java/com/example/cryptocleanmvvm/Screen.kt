package com.example.cryptocleanmvvm

sealed class Screen(val route: String) {
    object  CoinListScreen: Screen("coin_list_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg  args: String) : String {
        return  buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
