package com.example.cryptocleanmvvm.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocleanmvvm.common.Resource
import com.example.cryptocleanmvvm.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf<CoinListState>(CoinListState.Loading())
    val state : State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinListState.Success(coinList = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CoinListState.Error(error = result.message ?: "an unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinListState.Loading()
                }
            }
        }.launchIn(viewModelScope)
    }

}