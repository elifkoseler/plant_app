package com.elif.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.elif.presentation.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OnboardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.currentStep.observe(viewLifecycleOwner) { step ->
            binding.titleText.setText(step.titleRes)

            if (step.descriptionRes != null) {
                binding.descriptionText.visibility = View.VISIBLE
                binding.descriptionText.setText(step.descriptionRes)
            } else {
                binding.descriptionText.visibility = View.GONE
            }

            binding.plantImage.setImageResource(step.imageRes)
            binding.backgroundImage.setImageResource(step.backgroundImageRes)
            binding.nextButton.setText(step.buttonStringRes)
        }

        binding.nextButton.setOnClickListener {
            val didAdvance = viewModel.nextStep()
            if (!didAdvance) {
                //findNavController().navigate(R.id.action_onboarding_to_paywall)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
