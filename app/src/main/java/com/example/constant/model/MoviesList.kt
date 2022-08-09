package com.example.constant.model

data class MoviesList(val items: List<Movie>) {
    operator fun get(position: Int): Movie {
        return items[position]
    }
}

data class Movie(
    val title: String,
    val directorName: String,
    val releaseYear: Int,
    val actors: List<Actor>
)

data class Actor(
    val actorName: String
)
