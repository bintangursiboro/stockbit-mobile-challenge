package com.ijniclohot.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Networking {

    private const val BASE_URL = "https://min-api.cryptocompare.com/"
    private const val API_KEY = "c3b891784def916e7f679b9395d32b09b7924bdf3d85edba030efa343c92ec5b"

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

    private val httpClient = OkHttpClient.Builder().addInterceptor {
        val original = it.request()
        val request = original.newBuilder()
            .header("Apikey", API_KEY)
            .method(original.method(), original.body())
            .build()

        it.proceed(request)
    }.addInterceptor(httpLoggingInterceptor).build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}