package com.yuri.globoapp.data.repository

import com.yuri.globoapp.data.api.RetrofitInstante
import com.yuri.globoapp.data.model.ListFilmes

class FilmeRepository : IFilmeRepository {
    override suspend fun getPopularFilmes(api_key: String, pagina: Int): ListFilmes {
        return RetrofitInstante.apiTmdb.getPopularFilmes(api_key, pagina)
    }

    override suspend fun getFilmesPorNome(api_key: String, query: String, pagina: Int): ListFilmes {
        return RetrofitInstante.apiTmdb.getFilmesPorNome(api_key,query,pagina)
    }
}