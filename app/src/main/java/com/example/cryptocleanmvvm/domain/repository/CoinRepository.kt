package com.example.cryptocleanmvvm.domain.repository

import com.example.cryptocleanmvvm.data.remote.dto.CoinDetailDto
import com.example.cryptocleanmvvm.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}