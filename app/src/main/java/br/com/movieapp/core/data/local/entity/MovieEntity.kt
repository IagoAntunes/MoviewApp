package br.com.movieapp.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import retrofit2.http.Url

@Entity(tableName = "Movies")
data class MovieEntity(

    @PrimaryKey(autoGenerate = false)
    val movieId: Int,
    val title: String,
    val imageUrl: String,

)