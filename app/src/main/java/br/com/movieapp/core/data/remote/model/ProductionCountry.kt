package br.com.movieapp.core.data.remote.model

import com.google.gson.annotations.SerializedName

//MovieDetailResponse
data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso1661: String,
    @SerializedName("name")
    val name: String
)