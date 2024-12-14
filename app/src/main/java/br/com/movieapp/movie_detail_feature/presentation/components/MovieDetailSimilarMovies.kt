package br.com.movieapp.movie_detail_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.core.presentation.components.ErrorScreen
import br.com.movieapp.core.presentation.components.LoadingView
import br.com.movieapp.movie_popular_feature.presentation.components.MovieItem

@Composable
fun MovieDetailSimilarMovies(
    pagingMoviesSimilar: LazyPagingItems<Movie>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        items(pagingMoviesSimilar.itemCount){ index ->
            val movie = pagingMoviesSimilar[index]

            movie?.let{ movie ->
                MovieItem(
                    id = movie.id,
                    voteAverage = movie.voteAverage,
                    imageUrl = movie.imageUr,
                    onClick = {

                    }
                )
            }

        }
        pagingMoviesSimilar.apply{
            when{
                loadState.refresh is LoadState.Loading -> {
                    item( span = {
                        GridItemSpan(3)
                    }) {
                        LoadingView()
                    }
                }
                loadState.append is LoadState.Loading -> {
                    item( span = {
                        GridItemSpan(3)
                    }) {
                        LoadingView()
                    }
                }
                loadState.refresh is LoadState.Error -> {
                    val error = pagingMoviesSimilar.loadState.refresh as LoadState.Error
                    item( span = {
                        GridItemSpan(3)
                    }) {
                        ErrorScreen(message = error.error.message.toString()){
                            retry()
                        }
                    }
                }
                loadState.append is LoadState.Error -> {
                    val error = pagingMoviesSimilar.loadState.refresh as LoadState.Error
                    item( span = {
                        GridItemSpan(3)
                    }) {
                        ErrorScreen(message = error.error.message.toString()){
                            retry()
                        }
                    }
                }
            }
        }
    }


}

