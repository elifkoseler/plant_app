package com.elif.domain.usecase

import javax.inject.Inject

data class ArticleUseCases @Inject constructor(
    val getArticlesFromRemote: GetArticlesFromRemoteUseCase,
    val getArticlesFromLocal: GetArticlesFromLocalUseCase,
    val saveArticlesToLocal: SaveArticlesToLocalUseCase
)
