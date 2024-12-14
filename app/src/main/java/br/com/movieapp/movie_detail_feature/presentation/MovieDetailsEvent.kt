package br.com.movieapp.movie_detail_feature.presentation

import br.com.movieapp.core.domain.model.Movie

sealed class MovieDetailsEvent {
    data class GetMovieDetails(val movieId: Int) : MovieDetailsEvent()
    data class AddFavorite(val movie: Movie) : MovieDetailsEvent()
    data class CheckedFavorite(val movieId: Int) : MovieDetailsEvent()
    data class RemovedFavorite(val movie: Movie) : MovieDetailsEvent()
}