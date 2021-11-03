package com.yuri.globoapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val URL_TMDB_API = "https://api.themoviedb.org"
const val URL_TMDB_IMAGE = "https://image.tmdb.org/t/p/w500"
const val API_KEY_TMDB = "49aa94a82805cf265b5d277dddbd1d0c"

object RetrofitInstante {

    private var interceptor = HttpLoggingInterceptor()

    private val retrofit by lazy{
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        var client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        Retrofit.Builder()
            .baseUrl(URL_TMDB_API)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiTmdb : TmdbApi by lazy {
        retrofit.create(TmdbApi::class.java)
    }
}