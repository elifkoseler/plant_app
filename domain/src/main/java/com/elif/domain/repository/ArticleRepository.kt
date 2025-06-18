package com.elif.domain.repository

import com.elif.domain.model.Article
import dagger.Component
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface ArticleRepository{
    suspend fun fetchArticlesFromRemote(): List<Article>
    suspend fun saveArticlesToLocal(articles: List<Article>)
    suspend fun getArticlesFromLocal(): List<Article>
}
