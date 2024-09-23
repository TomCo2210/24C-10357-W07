package dev.tomco.a24c_10357_w07.interfaces

import dev.tomco.a24c_10357_w07.models.Movie

interface MovieCallback {
    fun favoriteButtonClicked(movie: Movie, position: Int)
}