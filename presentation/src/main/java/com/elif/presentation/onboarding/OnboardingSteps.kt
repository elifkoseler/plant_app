package com.elif.presentation.onboarding

import androidx.annotation.StringRes

data class OnboardingStep(
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int?,
    val imageRes: Int,
    val backgroundImageRes: Int,
    val buttonStringRes: Int
)
