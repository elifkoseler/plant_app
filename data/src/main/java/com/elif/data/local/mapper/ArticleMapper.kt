package com.elif.data.local.mapper

import com.elif.data.local.entity.ArticleEntity
import com.elif.data.remote.model.ArticleDto
import com.elif.domain.model.Article

fun ArticleDto.toDomain() = Article(
    id = id,
    title = title,
    subtitle = subtitle,
    imageUri = imageUri,
    uri = uri,
    order = order
)

fun ArticleEntity.toDomain() = Article(
    id = id,
    title = title,
    subtitle = subtitle,
    imageUri = imageUri,
    uri = uri,
    order = order
)

fun Article.toEntity() = ArticleEntity(
    id = id,
    title = title,
    subtitle = subtitle,
    imageUri = imageUri,
    uri = uri,
    order = order
)

