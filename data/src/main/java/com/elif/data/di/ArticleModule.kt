package com.elif.data.di

import com.elif.data.local.dao.ArticleDao
import com.elif.data.remote.ArticleApi
import com.elif.data.repository.ArticleRepositoryImpl
import com.elif.domain.repository.ArticleRepository
import com.elif.domain.usecase.ArticleUseCases
import com.elif.domain.usecase.GetArticlesFromLocalUseCase
import com.elif.domain.usecase.GetArticlesFromRemoteUseCase
import com.elif.domain.usecase.SaveArticlesToLocalUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleModule {

    @Provides
    fun provideArticleRepository(
        articleRestApi: ArticleApi,
        dao: ArticleDao
    ): ArticleRepositoryImpl {
        return ArticleRepositoryImpl(
            api = articleRestApi,
            dao = dao
        )
    }

    @Provides
    @Singleton
    fun provideArticleApi(retrofit: Retrofit): ArticleApi {
        return retrofit.create(ArticleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetArticlesFromRemoteUseCase(repository: ArticleRepository): GetArticlesFromRemoteUseCase {
        return GetArticlesFromRemoteUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetArticlesFromLocalUseCase(repository: ArticleRepository): GetArticlesFromLocalUseCase {
        return GetArticlesFromLocalUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSaveArticlesToLocalUseCase(repository: ArticleRepository): SaveArticlesToLocalUseCase {
        return SaveArticlesToLocalUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideArticleUseCases(
        remote: GetArticlesFromRemoteUseCase,
        local: GetArticlesFromLocalUseCase,
        save: SaveArticlesToLocalUseCase
    ): ArticleUseCases {
        return ArticleUseCases(
            getArticlesFromRemote = remote,
            getArticlesFromLocal = local,
            saveArticlesToLocal = save
        )
    }
}
