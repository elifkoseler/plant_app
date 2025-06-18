package com.elif.presentation.paywall

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.elif.presentation.R
import com.elif.presentation.databinding.FragmentPaywallBinding
import com.elif.presentation.paywall.adapter.CardAdapter

class PaywallFragment : Fragment() {

    private var _binding: FragmentPaywallBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PaywallViewModel by viewModels()
    private val adapter = CardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPaywallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupPlanSelection()
        setupRecyclerView()
        observeCards()
        observeActions()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCards.adapter = adapter
        binding.recyclerViewCards.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun observeCards() {
        viewModel.cards.observe(viewLifecycleOwner) { cards ->
            adapter.setItems(cards)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeActions() {
        binding.closeButton.setOnClickListener {
            findNavController().navigate(R.id.action_paywall_to_home)
        }
        binding.tryFreeButton.setOnClickListener {
            Toast.makeText(requireContext(), "Subscription Activated!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_paywall_to_home)
        }
    }

    private fun setupPlanSelection() {
        binding.radioOneMonth.isChecked = false
        binding.radioOneYear.isChecked = true
        binding.cardOneYear.setBackgroundResource(R.drawable.card_selected_border)

        binding.cardOneMonth.setOnClickListener {
            binding.cardOneMonth.setBackgroundResource(R.drawable.card_selected_border)
            binding.cardOneYear.setBackgroundColor(Color.TRANSPARENT)
            binding.radioOneMonth.isChecked = true
            binding.radioOneYear.isChecked = false
        }
        binding.radioOneMonth.setOnClickListener {
            binding.cardOneMonth.setBackgroundResource(R.drawable.card_selected_border)
            binding.cardOneYear.setBackgroundColor(Color.TRANSPARENT)
            binding.radioOneMonth.isChecked = true
            binding.radioOneYear.isChecked = false
        }
        binding.cardOneYear.setOnClickListener {
            binding.cardOneYear.setBackgroundResource(R.drawable.card_selected_border)
            binding.cardOneMonth.setBackgroundColor(Color.TRANSPARENT)
            binding.radioOneMonth.isChecked = false
            binding.radioOneYear.isChecked = true
        }
        binding.radioOneYear.setOnClickListener {
            binding.cardOneYear.setBackgroundResource(R.drawable.card_selected_border)
            binding.cardOneMonth.setBackgroundColor(Color.TRANSPARENT)
            binding.radioOneMonth.isChecked = false
            binding.radioOneYear.isChecked = true
        }
    }
}

