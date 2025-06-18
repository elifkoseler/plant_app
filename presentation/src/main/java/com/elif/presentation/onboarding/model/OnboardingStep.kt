package com.elif.presentation.onboarding.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingStep(
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int?,
    @DrawableRes val imageRes: Int,
    @DrawableRes val backgroundImageRes: Int,
    @StringRes val buttonStringRes: Int,
    @DrawableRes val sliderRes: Int?,
    @StringRes val termsStringRes: Int?
)