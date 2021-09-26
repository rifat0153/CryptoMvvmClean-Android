package com.example.cryptocleanmvvm.presentation.coin_detail

import com.example.cryptocleanmvvm.domain.model.Coin
import com.example.cryptocleanmvvm.domain.model.CoinDetail

sealed class CoinDetailState {
    data class Success(val coinList: CoinDetail? = null ) : CoinDetailState()
    class Error(val error: String) : CoinDetailState()
    class  Loading() : CoinDetailState()
}
