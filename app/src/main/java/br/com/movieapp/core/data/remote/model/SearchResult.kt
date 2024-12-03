package br.com.movieapp.core.data.remote.model

import com.google.gson.annotations.SerializedName

//SearchResponse
data class SearchResult(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("genre_ids")
    val gender: Int,
    @SerializedName("id")
    val genreIds: List<Int>,
    @SerializedName("original_language")
    val id: Int,
    @SerializedName("original_title")
    val knownFor: List<KnownFor>,
    @SerializedName("overview")
    val knownForDepartment: String,
    @SerializedName("popularity")
    val mediaType: String,
    @SerializedName("poster_path")
    val name: String,
    @SerializedName("release_date")
    val originCountry: List<String>,
    @SerializedName("title")
    val originalLanguage: String,
    @SerializedName("video")
    val originalName: String,
    @SerializedName("vote_average")
    val originalTitle: String,
    @SerializedName("vote_count")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val profilePath: String,
    @SerializedName("title")
    val releaseDate: String,
    @SerializedName("video")
    val title: String,
    @SerializedName("vote_average")
    val video: Boolean,
    @SerializedName("vote_count")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)