package com.example.cryptocleanmvvm.presentation.coin_detail

import android.content.Context
import android.view.View
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocleanmvvm.domain.model.Coin
import com.example.cryptocleanmvvm.presentation.coin_list.CoinListFragment

@Composable
fun CoinDetailScreen(navController: NavController, coinId: String?,  coin: Coin? = null) {

    Text(text = "Coin Id is: $coinId")
}

