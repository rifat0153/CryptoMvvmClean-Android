package com.example.cryptocleanmvvm.domain.use_case.get_coin

import android.util.Log
import com.example.cryptocleanmvvm.common.Constants
import com.example.cryptocleanmvvm.common.Resource
import com.example.cryptocleanmvvm.data.remote.dto.toCoinDetail
import com.example.cryptocleanmvvm.domain.model.CoinDetail
import com.example.cryptocleanmvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading<CoinDetail>())

            Log.d("AppDebug", "Coid id is use is $coinId")
            val coinDto = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(data = coinDto.toCoinDetail()))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<CoinDetail>(
                    message = e.localizedMessage
                        ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }

    }


}