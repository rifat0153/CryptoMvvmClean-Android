package com.example.cryptocleanmvvm.presentation.coin_list

import com.example.cryptocleanmvvm.domain.model.Coin

sealed class CoinListState {
    data class Success(val coinList: List<Coin> = emptyList()) : CoinListState()
    class Error(val error: String) : CoinListState()
    class  Loading() : CoinListState()
}
