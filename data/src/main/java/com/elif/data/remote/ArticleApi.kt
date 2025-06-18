package com.elif.data.remote

import com.elif.data.remote.model.ArticleDto
import retrofit2.http.GET

interface ArticleApi {
    @GET("getQuestions")
    suspend fun getArticles(): List<ArticleDto>
}
