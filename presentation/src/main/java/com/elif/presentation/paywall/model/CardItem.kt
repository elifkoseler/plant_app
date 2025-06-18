package com.elif.presentation.paywall.model

import androidx.annotation.StringRes

data class CardItem(
    val imageResId: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
)