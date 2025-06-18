package com.elif.domain.usecase

import com.elif.domain.model.Article
import com.elif.domain.repository.ArticleRepository

class SaveArticlesToLocalUseCase(
    private val repository: ArticleRepository
) {
    suspend operator fun invoke(articles: List<Article>) {
        repository.saveArticlesToLocal(articles)
    }
}
