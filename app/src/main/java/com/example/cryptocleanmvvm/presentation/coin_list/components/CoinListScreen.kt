package com.example.cryptocleanmvvm.presentation.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocleanmvvm.presentation.coin_list.CoinListState
import com.example.cryptocleanmvvm.presentation.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
//    viewCoinDetail: () -> Unit
) {

    val state: CoinListState = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is CoinListState.Loading -> CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                )
            )

            is CoinListState.Error ->   Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier. align(Alignment.Center)
            )

            is CoinListState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.coinList.size) { coin ->

                        CoinListItem(coin = state.coinList[coin], navController = navController )

                    }
                }
            }
        }
    }

}