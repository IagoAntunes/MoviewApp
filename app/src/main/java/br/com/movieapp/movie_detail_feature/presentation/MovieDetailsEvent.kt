package br.com.movieapp.movie_detail_feature.presentation

sealed class MovieDetailsEvent {
    data class GetMovieDetails(val movieId: Int) : MovieDetailsEvent()
}