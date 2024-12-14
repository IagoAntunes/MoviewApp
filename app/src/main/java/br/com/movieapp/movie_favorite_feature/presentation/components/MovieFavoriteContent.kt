package br.com.movieapp.movie_favorite_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.ui.theme.black

@Composable
fun MovieFavoriteContent(
    paddingValues: PaddingValues,
    movies: List<Movie>,
    onClick: (id:Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    Box(modifier = Modifier.background(black)){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = paddingValues,
            content = {
                items(
                    items = movies,
                    key = { item: Movie ->
                        item.id
                    }
                ) { movieItem ->
                    MovieFavoriteItem(
                        movie = movieItem,
                        onClick = onClick
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun PreviewMovieFavoriteContent() {
    MovieFavoriteContent(
        paddingValues = PaddingValues(8.dp),
        movies = listOf(
            Movie(
                id = 1,
                title = "Homem Aranha",
                imageUr = "https://image.tmdb.org/t/p/w500/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg"
            )
        ),
        onClick = {}
    )
}