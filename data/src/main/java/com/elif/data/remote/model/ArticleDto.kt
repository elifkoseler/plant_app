package com.elif.data.remote.model

import com.google.gson.annotations.SerializedName

data class ArticleDto(
    val id: Int,
    val title: String,
    val subtitle: String,
    @SerializedName("image_uri") val imageUri: String,
    val uri: String,
    val order: Int
)

