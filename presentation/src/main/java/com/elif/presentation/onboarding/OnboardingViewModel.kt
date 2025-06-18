package com.elif.presentation.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elif.presentation.R

class OnboardingViewModel : ViewModel() {

    private val _currentIndex = MutableLiveData(0)
    val currentIndex: LiveData<Int> = _currentIndex

    private val _currentStep = MediatorLiveData<OnboardingStep>().apply {
        addSource(_currentIndex) { index ->
            value = steps.getOrNull(index)
        }
    }
    val currentStep: LiveData<OnboardingStep> = _currentStep

    fun nextStep(): Boolean {
        val next = (_currentIndex.value ?: 0) + 1
        return if (next < steps.size) {
            _currentIndex.value = next
            true
        } else {
            false
        }
    }

    private val steps = listOf(
        OnboardingStep(
            titleRes = R.string.welcome_to_plantapp,
            descriptionRes = R.string.identify_more_than_3000_plants_and_88_accuracy,
            imageRes = R.drawable.start_plant,
            backgroundImageRes = R.drawable.background,
            buttonStringRes = R.string.get_started,
            sliderRes = null,
            termsStringRes = R.string.by_tapping_next_you_are_agreeing_to_plantid_nterms_of_use_privacy_policy
        ),
        OnboardingStep(
            titleRes = R.string.take_a_photo_to_identify,
            descriptionRes = null,
            imageRes = R.drawable.identify_plant,
            backgroundImageRes = R.drawable.background,
            buttonStringRes = R.string.continue_button,
            sliderRes = R.drawable.slider_1,
            termsStringRes = null
        ),
        OnboardingStep(
            titleRes = R.string.get_plant_care_guides,
            descriptionRes = null,
            imageRes = R.drawable.care_guides,
            backgroundImageRes = R.drawable.background,
            buttonStringRes = R.string.continue_button,
            sliderRes = R.drawable.slider_2,
            termsStringRes = null
        )
    )
}
