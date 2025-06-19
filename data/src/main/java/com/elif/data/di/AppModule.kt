package com.elif.data.di

import android.content.Context
import androidx.room.Room
import com.elif.data.local.dao.ArticleDao
import com.elif.data.local.database.AppDatabase
import com.elif.data.remote.ArticleApi
import com.elif.data.remote.RetrofitInstance
import com.elif.data.repository.ArticleRepositoryImpl
import com.elif.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Database
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(database: AppDatabase): ArticleDao {
        return database.articleDao()
    }

    // API
    @Provides
    @Singleton
    fun provideArticleApi(): ArticleApi {
        return Retrofit.Builder()
            .baseUrl("https://dummy-api-jtg6bessta-ey.a.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArticleApi::class.java)
    }

    // Repository
    @Binds
    @Singleton
    fun provideArticleRepository(
        api: ArticleApi,
        dao: ArticleDao
    ): ArticleRepository {
        return ArticleRepositoryImpl(api, dao)
    }


}