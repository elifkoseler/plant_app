package com.elif.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elif.domain.model.Article
import com.elif.domain.usecase.ArticleUseCases
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCases: ArticleUseCases
) : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    fun loadArticles() {
        viewModelScope.launch {
            try {
                val remoteArticles = useCases.getArticlesFromRemote()
                _articles.value = remoteArticles
                useCases.saveArticlesToLocal(remoteArticles)
            } catch (e: Exception) {
                val localArticles = useCases.getArticlesFromLocal()
                _articles.value = localArticles
            }
        }
    }
}
