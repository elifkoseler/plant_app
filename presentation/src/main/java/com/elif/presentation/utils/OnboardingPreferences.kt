package com.elif.presentation.utils

import android.content.Context

object OnboardingPreferences {
    private const val PREFS_NAME = "onboarding_prefs"
    private const val KEY_COMPLETED = "onboarding_completed"

    fun setCompleted(context: Context, completed: Boolean) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_COMPLETED, completed).apply()
    }

    fun isCompleted(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_COMPLETED, false)
    }
}
