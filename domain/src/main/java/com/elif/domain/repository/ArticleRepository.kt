package com.elif.domain.repository

import com.elif.domain.model.Article

interface ArticleRepository {
    suspend fun fetchArticlesFromRemote(): List<Article>
    suspend fun saveArticlesToLocal(articles: List<Article>)
    suspend fun getArticlesFromLocal(): List<Article>
}
