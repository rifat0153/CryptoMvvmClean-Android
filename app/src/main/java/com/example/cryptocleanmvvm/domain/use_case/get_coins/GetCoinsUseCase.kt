package com.example.cryptocleanmvvm.domain.use_case.get_coins

import com.example.cryptocleanmvvm.common.CoinsResource
import com.example.cryptocleanmvvm.common.MyResource
import com.example.cryptocleanmvvm.common.Resource
import com.example.cryptocleanmvvm.data.remote.dto.toCoin
import com.example.cryptocleanmvvm.domain.model.Coin
import com.example.cryptocleanmvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<MyResource> = flow {

        try {
            emit(MyResource.Loading())

            val coins = repository.getCoins()
            emit(MyResource.Success<List<Coin>>(data = coins.map { it.toCoin() }))

        } catch (e: HttpException) {
            emit(MyResource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                MyResource.Error(
                    message = e.localizedMessage
                        ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }

    }

}