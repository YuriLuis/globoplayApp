package com.yuri.globoapp.data.api

import com.yuri.globoapp.data.model.ListFilmes
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {

    @GET("/3/movie/popular")
    suspend fun getPopularFilmes(
        @Query("api_key") api_key: String,
        @Query("page") page : Int
    ) : ListFilmes

    @GET("/3/search/movie")
    suspend fun getFilmesPorNome(
        @Query("api_key") api_key: String,
        @Query("query") query : String,
        @Query("page") page: Int
    ) : ListFilmes
}