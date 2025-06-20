package com.elif.domain.di

import com.elif.domain.usecase.ArticleUseCases
import com.elif.domain.usecase.GetArticlesFromLocalUseCase
import com.elif.domain.usecase.GetArticlesFromRemoteUseCase
import com.elif.domain.usecase.SaveArticlesToLocalUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainDiModule {
    @Provides
    fun provideArticleUseCases(
        getArticlesFromRemote: GetArticlesFromRemoteUseCase,
        getArticlesFromLocal: GetArticlesFromLocalUseCase,
        saveArticlesToLocal: SaveArticlesToLocalUseCase
    ): ArticleUseCases {
        return ArticleUseCases(
            getArticlesFromRemote = getArticlesFromRemote,
            getArticlesFromLocal = getArticlesFromLocal,
            saveArticlesToLocal = saveArticlesToLocal
        )
    }
}