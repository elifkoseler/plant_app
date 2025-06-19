package com.elif.plantapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.elif.presentation.utils.OnboardingPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        val navInflater = navController.navInflater
        val graph = navInflater.inflate(com.elif.presentation.R.navigation.presentation_nav_graph)

        val startDestination = if (OnboardingPreferences.isCompleted(this)) {
            R.id.homeFragment
        } else {
            R.id.onboardingFragment
        }

        graph.setStartDestination(startDestination)
        navController.graph = graph
    }
}
