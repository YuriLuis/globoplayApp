package com.yuri.globoapp.ui.main.view.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.yuri.globoapp.R
import com.yuri.globoapp.data.api.API_KEY_TMDB
import com.yuri.globoapp.data.repository.FilmeRepository
import com.yuri.globoapp.databinding.FragmentListFilmesBinding
import com.yuri.globoapp.ui.base.ListFilmesFragmentViewModelFactory
import com.yuri.globoapp.ui.main.adapter.FilmeAdapter
import com.yuri.globoapp.ui.main.viewmodel.ListFilmesFragmentViewModel

class ListFilmesFragment : Fragment(R.layout.fragment_list_filmes) {

    private lateinit var binding : FragmentListFilmesBinding

    private val viewModel: ListFilmesFragmentViewModel by activityViewModels {
        ListFilmesFragmentViewModelFactory(
            FilmeRepository()
        )
    }

    private var adapter = FilmeAdapter()

    private lateinit var recyclerView: RecyclerView

    private lateinit var searchView : SearchView

    private lateinit var textViewReset : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_filmes, container, false)
        setupObserversListFilmes()
        initComponents()
        return binding.root
    }

    private fun setupObserversListFilmes(){
        viewModel.listFilmes.observe(viewLifecycleOwner, {
            adapter.setFilmes(it)
        })
    }

    private fun initComponents(){
        recyclerView = binding.recycclerview
        searchView = binding.searchView
        textViewReset = binding.txtReset

        setupRecyclerView()
        searchviewEventSearch()
        setupObserverSearchView()
    }

    private fun searchviewEventSearch(){
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                viewModel.getFilmePorNome(API_KEY_TMDB, query.toString(), 1)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.equals("")){
                    viewModel.getPopularFilmes(API_KEY_TMDB, 1)
                }
                return true
            }
        })
    }

    private fun setupObserverSearchView(){
        viewModel.isFilter.observe(viewLifecycleOwner, {
            textViewReset.visibility =
                if(it) View.VISIBLE else View.VISIBLE
        })
    }

    private fun setupRecyclerView(){
        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getPopularFilmes(API_KEY_TMDB, 464)
    }
}