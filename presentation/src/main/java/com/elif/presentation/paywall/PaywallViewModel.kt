package com.elif.presentation.paywall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elif.presentation.R
import com.elif.presentation.paywall.model.CardItem

class PaywallViewModel : ViewModel() {

    private val _cards = MutableLiveData<List<CardItem>>()
    val cards: LiveData<List<CardItem>> = _cards

    init {
        loadCards()
    }

    private fun loadCards() {
        _cards.value = listOf(
            CardItem(R.drawable.scan, R.string.unlimited, R.string.plant_identify),
            CardItem(R.drawable.fast, R.string.faster, R.string.process)
        )
    }
}
