package com.elif.presentation.onboarding

import androidx.lifecycle.ViewModel
import com.elif.presentation.R

class OnboardingViewModel : ViewModel() {
    private val steps = listOf(
        OnboardingStep(
            titleRes = R.string.welcome_to_plantapp,
            descriptionRes = R.string.identify_more_than_3000_plants_and_88_accuracy,
            imageRes = R.drawable.start_plant,
            backgroundImageRes = R.drawable.background,
            buttonStringRes = R.string.get_started
        ),
        OnboardingStep(
            titleRes = R.string.take_a_photo_to_identify,
            descriptionRes = null,
            imageRes = R.drawable.identify_plant,
            backgroundImageRes = R.drawable.background,
            buttonStringRes = R.string.continue_button
        ),
        OnboardingStep(
            titleRes = R.string.get_plant_care_guides,
            descriptionRes = null,
            imageRes = R.drawable.care_guides,
            backgroundImageRes = R.drawable.background,
            buttonStringRes = R.string.continue_button
        )
    )
}
