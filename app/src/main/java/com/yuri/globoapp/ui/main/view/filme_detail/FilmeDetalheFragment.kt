package com.yuri.globoapp.ui.main.view.filme_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yuri.globoapp.R
import com.yuri.globoapp.databinding.FragmentFilmeDetalheBinding
import com.yuri.globoapp.databinding.FragmentListFilmesBinding

class FilmeDetalheFragment : Fragment() {

    private lateinit var binding : FragmentFilmeDetalheBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filme_detalhe, container, false)

        return binding.root
    }
}