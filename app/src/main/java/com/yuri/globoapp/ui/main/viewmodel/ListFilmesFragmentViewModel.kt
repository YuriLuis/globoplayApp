package com.yuri.globoapp.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuri.globoapp.data.model.Filme
import com.yuri.globoapp.data.repository.FilmeRepository
import kotlinx.coroutines.launch

class ListFilmesFragmentViewModel(
    private val repository: FilmeRepository
) : ViewModel() {
    var listFilmes = MutableLiveData<List<Filme>>()

    var isFilter = MutableLiveData<Boolean>()

    init {
        isFilter.value = false
    }

    fun getPopularFilmes(api_key: String, pagina: Int){
        viewModelScope.launch {
            val filmes = repository.getPopularFilmes(api_key, pagina)
            listFilmes.value = filmes.results
        }
    }

    fun getFilmePorNome(api_key: String, query: String, pagina: Int){
        viewModelScope.launch {
            val filmes = repository.getFilmesPorNome(api_key,query,pagina )
            listFilmes.value = filmes.results
            isFilter.value = true
        }
    }
}