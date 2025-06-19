package com.elif.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.elif.presentation.databinding.FragmentHomeBinding
import com.elif.presentation.home.adapter.ArticleAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    private val articleAdapter = ArticleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        observeArticles()

        lifecycleScope.launch {
            viewModel.loadArticles()
        }
    }

    private fun setupRecyclerView() {
        binding.articleRecyclerView.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun observeArticles() {
        viewModel.articles.observe(viewLifecycleOwner) { articles ->
            articleAdapter.setArticles(articles)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
