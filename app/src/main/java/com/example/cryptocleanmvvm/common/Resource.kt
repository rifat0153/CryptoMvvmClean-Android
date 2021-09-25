package com.example.cryptocleanmvvm.common

import com.example.cryptocleanmvvm.domain.model.Coin
import com.example.cryptocleanmvvm.domain.model.CoinDetail

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}

sealed class MyResource {
    class  Success<T>(data: T?) :MyResource()
    class  Error(message: String) :MyResource()
    class Loading() : MyResource()
}


sealed class CoinsResource(val data: List<Coin>? = null, val message: String? = null) {
    class  Success(data: List<Coin>) :CoinsResource()
    class  Error(message: String) :CoinsResource()
    class Loading() : CoinsResource()
}

sealed class CoinsDetailesource(val data: CoinDetail? = null, val message: String? = null) {
    class  Success(data: CoinDetail) :CoinsDetailesource()
    class  Error(message: String) :CoinsDetailesource()
    class Loading() : CoinsDetailesource()
}
