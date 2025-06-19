package com.elif.data.repository

import com.elif.data.local.dao.ArticleDao
import com.elif.data.local.mapper.toDomain
import com.elif.data.local.mapper.toEntity
import com.elif.data.remote.ArticleApi
import com.elif.domain.model.Article
import com.elif.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: ArticleApi,
    private val dao: ArticleDao
) : ArticleRepository {

    override suspend fun fetchArticlesFromRemote(): List<Article> {
        return try {
            api.getArticles().map { it.toDomain() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun saveArticlesToLocal(articles: List<Article>) {
        dao.insertArticles(articles.map { it.toEntity() })
    }

    override suspend fun getArticlesFromLocal(): List<Article> {
        return dao.getAllArticles().map { it.toDomain() }
    }
}

