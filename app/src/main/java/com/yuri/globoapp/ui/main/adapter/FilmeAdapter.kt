package com.yuri.globoapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yuri.globoapp.R
import com.yuri.globoapp.data.api.URL_TMDB_IMAGE
import com.yuri.globoapp.data.model.Filme

class FilmeAdapter : RecyclerView.Adapter<FilmeAdapter.FilmesViewHolder>() {

    private var listFilmes : List<Filme> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_list_filmes, parent ,false)
        return FilmesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        holder.bind(listFilmes[position])
    }

    override fun getItemCount(): Int {
        return listFilmes.size
    }

    fun setFilmes(filmes: List<Filme>){
        listFilmes = filmes
        notifyDataSetChanged()

    }

    class FilmesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var image_character: ImageView = itemView.findViewById(R.id.character_img)

        fun bind(filme: Filme){
            Picasso.get().load(URL_TMDB_IMAGE+filme.poster_path).into(image_character)
        }
    }

}