package com.yuri.globoapp.data.model

import java.io.Serializable

data class Filme(
    var poster_path : String,
    var id : Int,
    var title : String,
    var release_date: String,
    var overview : String,
    var genre_ids: List<Int>
) : Serializable{
}