package br.com.movieapp.movie_favorite_feature.domain.repository

import br.com.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieFavoriteRepository {

    fun getMovies() : Flow<List<Movie>>
    suspend fun insert(movie: Movie) : Unit
    suspend fun delete(movie: Movie) : Unit
    suspend fun isFavorite(movieId: Int) : Boolean

}