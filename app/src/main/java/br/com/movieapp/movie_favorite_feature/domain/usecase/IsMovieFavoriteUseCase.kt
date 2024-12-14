package br.com.movieapp.movie_favorite_feature.domain.usecase

import br.com.movieapp.core.util.ResultData
import br.com.movieapp.movie_favorite_feature.domain.repository.MovieFavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface IsMovieFavoriteUseCase{
    operator fun invoke(params: Params) : Flow<ResultData<Boolean>>
    data class Params(val movieId: Int)
}

class IsMovieFavoriteUseCaseImpl @Inject constructor(
    private val movieFavoriteRepository: MovieFavoriteRepository
) : IsMovieFavoriteUseCase{
    override fun invoke(params: IsMovieFavoriteUseCase.Params): Flow<ResultData<Boolean>> {
        return flow {
            try {
                emit(ResultData.Loading)
                val isFavorite = movieFavoriteRepository.isFavorite(params.movieId)
                emit(ResultData.Success(isFavorite))
            } catch (e: Exception) {
                emit(ResultData.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}