package com.example.cryptocleanmvvm.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocleanmvvm.common.Constants
import com.example.cryptocleanmvvm.common.Resource
import com.example.cryptocleanmvvm.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState.Loading())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID )?.let { coinId ->
            Log.d("CoinDetailViewModel", "Param : $coinId")
            getCoin(coinId)
        }
    }

     fun getCoin( coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState.Success(coin = result.data )
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState.Error(error = result.message ?: "an unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState.Loading()
                }
            }
        }.launchIn(viewModelScope)
    }

}