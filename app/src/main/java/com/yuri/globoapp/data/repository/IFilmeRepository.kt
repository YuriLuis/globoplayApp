package com.yuri.globoapp.data.repository

import com.yuri.globoapp.data.model.ListFilmes

interface IFilmeRepository {

    suspend fun getPopularFilmes(api_key: String, pagina: Int) : ListFilmes

    suspend fun getFilmesPorNome(api_key: String, query : String, pagina: Int) : ListFilmes
}