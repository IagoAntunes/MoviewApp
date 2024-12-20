package br.com.movieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.movieapp.core.presentation.navigation.BottomNavItem.MovieDetail
import br.com.movieapp.core.util.Constants
import br.com.movieapp.movie_detail_feature.presentation.MovieDetailScreen
import br.com.movieapp.movie_detail_feature.presentation.MovieDetailViewModel
import br.com.movieapp.movie_favorite_feature.presentation.MovieFavoriteScreen
import br.com.movieapp.movie_favorite_feature.presentation.MovieFavoriteViewModel
import br.com.movieapp.movie_popular_feature.presentation.screen.MoviePopularScreen
import br.com.movieapp.movie_popular_feature.presentation.viewModel.MoviePopularViewModel
import br.com.movieapp.search_movie_feature.MovieSearchViewModel
import br.com.movieapp.search_movie_feature.presentation.MovieSearchEvent
import br.com.movieapp.search_movie_feature.presentation.MovieSearchScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route
    ){
        composable(BottomNavItem.MoviePopular.route){
            val viewModel: MoviePopularViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            MoviePopularScreen(
                uiState = uiState,
                navigateToDetailMovie = { movieId ->
                    navController.navigate(MovieDetail.passMovieId(movieId))
                }
            )
        }
        composable(BottomNavItem.MovieSearch.route){
            val viewModel: MovieSearchViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            val onEvent: (MovieSearchEvent) -> Unit = viewModel::event
            val onFetch: (String) -> Unit = viewModel::fetch

            MovieSearchScreen(
                uiState = uiState,
                onEvent = onEvent,
                onFetch = onFetch,
                navigateToDetailMovie = { movieId ->
                    navController.navigate(MovieDetail.passMovieId(movieId))
                }
            )
        }
        composable(BottomNavItem.MovieFavorite.route){
            val viewModel: MovieFavoriteViewModel = hiltViewModel()
            val uiState = viewModel.uiState

            MovieFavoriteScreen(
                uiState,
                navigateToDetailMovie = { movieId ->
                    navController.navigate(MovieDetail.passMovieId(movieId))
                }
            )
        }

        composable(
            MovieDetail.route,
                arguments = listOf(
                    navArgument(Constants.MOVIE_DETAIL_ARGUMENT_KEY){
                        type = NavType.IntType
                        defaultValue = 0
                    }
                )
            ){
                val viewModel: MovieDetailViewModel = hiltViewModel()
                val uiState = viewModel.uiState
                val onAddFavorite = viewModel::favorite
                val checkedFavorite = viewModel::checkedFavorite

                val getMovieDetail = viewModel::getMovieDetail

                MovieDetailScreen(
                    movieId = it.arguments?.getInt(Constants.MOVIE_DETAIL_ARGUMENT_KEY),
                    uiState = uiState,
                    onAddFavorite = onAddFavorite,
                    checkedFavorite = checkedFavorite,
                    getMovieDetail = getMovieDetail
                )
            }
    }
}