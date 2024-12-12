package br.com.movieapp.search_movie_feature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.movieapp.core.domain.model.MovieSearch
import br.com.movieapp.core.presentation.components.ErrorScreen
import br.com.movieapp.core.presentation.components.LoadingView
import br.com.movieapp.movie_popular_feature.presentation.components.MovieItem
import br.com.movieapp.ui.theme.black

@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    pagingMovies: LazyPagingItems<MovieSearch>,
    query: String,
    onSearch: (String) -> Unit,
    onEvent: (MovieSearchEvent) -> Unit,
    onDetail: (movieId: Int) -> Unit
) {

    var isLoading by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
            .background(black),
    ) {
        SearchComponent(
            query = query,
            onSearch = {
                isLoading = true
                onSearch(it)
                isLoading = false
            },
            onQueryChangeEvent = {
                isLoading = true
                onEvent(it)
                isLoading = false
            },
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.heightIn(12.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            items(pagingMovies.itemCount){ index ->
                val movie = pagingMovies[index]
                movie?.let { search ->
                    println("MOVIE: $search")
                    MovieItem(
                        voteAverage = search.voteAverage,
                        imageUrl = search.imageUrl,
                        id = search.id,
                        onClick = { movieId ->
                            onDetail(movieId)
                        }
                    )
                }
            }
            pagingMovies.apply{
                when{
                    isLoading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingView()
                        }
                    }
                    loadState.refresh is LoadState.Error -> {
                        isLoading = false
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(
                                message = "Erro ao carregar filmes",
                                retry = {
                                    retry()
                                }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(
                                message = "Erro ao carregar filmes",
                                retry = {
                                    retry()
                                }
                            )
                        }
                    }

                }
            }

        }

    }

}