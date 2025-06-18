package com.elif.presentation.home

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elif.domain.model.Article
import com.elif.domain.usecase.ArticleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: ArticleUseCases
) : ViewModel(), LifecycleObserver {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    init {
        loadArticles()
    }

    fun loadArticles() {
        viewModelScope.launch {
            try {
                // Try to get from remote firsr
                val remoteArticles = useCases.getArticlesFromRemote()

                // Save to room
                useCases.saveArticlesToLocal(remoteArticles)

                // Get from local
                val localArticles = useCases.getArticlesFromLocal()
                _articles.value = localArticles

            } catch (e: Exception) {
                // If there is an exception then get from local
                _articles.value = useCases.getArticlesFromLocal()
            }
        }
    }
}

