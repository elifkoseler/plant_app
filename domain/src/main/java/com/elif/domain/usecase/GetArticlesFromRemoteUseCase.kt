package com.elif.domain.usecase

import com.elif.domain.model.Article
import com.elif.domain.repository.ArticleRepository
import javax.inject.Inject

class GetArticlesFromRemoteUseCase @Inject constructor(
    private val repository: ArticleRepository
) {
    suspend operator fun invoke(): List<Article> {
        return repository.fetchArticlesFromRemote()
    }
}
