package br.com.movieapp.core.data.remote.response

import br.com.movieapp.core.data.remote.model.Genre
import br.com.movieapp.core.data.remote.model.ProductionCompany
import br.com.movieapp.core.data.remote.model.ProductionCountry
import br.com.movieapp.core.data.remote.model.SpokenLanguage
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originCountry: List<String>,
    @SerializedName("original_title")
    val originalLanguage: String,
    @SerializedName("overview")
    val originalTitle: String,
    @SerializedName("popularity")
    val overview: String,
    @SerializedName("poster_path")
    val popularity: Double,
    @SerializedName("production_companies")
    val posterPath: String,
    @SerializedName("production_countries")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("release_date")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("revenue")
    val releaseDate: String,
    @SerializedName("runtime")
    val revenue: Long,
    @SerializedName("spoken_languages")
    val runtime: Int,
    @SerializedName("status")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("tagline")
    val status: String,
    @SerializedName("title")
    val tagline: String,
    @SerializedName("video")
    val title: String,
    @SerializedName("vote_average")
    val video: Boolean,
    @SerializedName("vote_count")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)