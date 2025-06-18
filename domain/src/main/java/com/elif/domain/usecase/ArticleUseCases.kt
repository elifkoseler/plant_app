package com.elif.domain.usecase

data class ArticleUseCases(
    val getArticlesFromRemote: GetArticlesFromRemoteUseCase,
    val getArticlesFromLocal: GetArticlesFromLocalUseCase,
    val saveArticlesToLocal: SaveArticlesToLocalUseCase
)
