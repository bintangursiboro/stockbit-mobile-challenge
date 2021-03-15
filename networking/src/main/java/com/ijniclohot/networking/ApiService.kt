package com.ijniclohot.networking

import com.ijniclohot.networking.model.CryptoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/top/totaltoptiervolfull")
    fun getWatchList(
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
        @Query("tsym") tsym: String,
        @Query("assetClass") assetClass: String?,
        @Query("ascending") ascending: Boolean?,
        @Query("sign") sign: Boolean?
    ): Observable<CryptoResponse>
}