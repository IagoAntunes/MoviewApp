package br.com.movieapp.movie_favorite_feature.domain.usecase

import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.core.util.ResultData
import br.com.movieapp.movie_favorite_feature.domain.repository.MovieFavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface DeleteMovieFavoriteUseCase{
    operator fun invoke(params: Params) : Flow<ResultData<Unit>>
    data class Params(val movie: Movie)
}

class DeleteMovieFavoriteUseCaseImpl @Inject constructor(
    private val movieFavoriteRepository: MovieFavoriteRepository
) : DeleteMovieFavoriteUseCase{
    override fun invoke(params: DeleteMovieFavoriteUseCase.Params): Flow<ResultData<Unit>> {
        return flow{
            val deleted =movieFavoriteRepository.delete(params.movie)

            emit(ResultData.Success(deleted))

        }.flowOn(Dispatchers.IO)
    }

}