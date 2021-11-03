package com.yuri.globoapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yuri.globoapp.data.repository.FilmeRepository
import com.yuri.globoapp.ui.main.viewmodel.ListFilmesFragmentViewModel

class ListFilmesFragmentViewModelFactory(
    private val repository: FilmeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListFilmesFragmentViewModel(repository) as T
    }
}