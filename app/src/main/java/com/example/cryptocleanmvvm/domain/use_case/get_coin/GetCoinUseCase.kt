package com.example.cryptocleanmvvm.domain.use_case.get_coin

import com.example.cryptocleanmvvm.common.CoinsDetailesource
import com.example.cryptocleanmvvm.common.CoinsResource
import com.example.cryptocleanmvvm.common.MyResource
import com.example.cryptocleanmvvm.data.remote.dto.toCoin
import com.example.cryptocleanmvvm.data.remote.dto.toCoinDetail
import com.example.cryptocleanmvvm.domain.model.CoinDetail
import com.example.cryptocleanmvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private  val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<MyResource> = flow {

        try {
            emit(MyResource.Loading())

            val coin = repository.getCoinById(coinId)
            emit(MyResource.Success<CoinDetail>(data = coin.toCoinDetail()))

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