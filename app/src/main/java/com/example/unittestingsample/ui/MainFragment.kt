package com.example.unittestingsample.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.unittestingsample.R
import com.example.unittestingsample.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)

        binding.fetchBtn.setOnClickListener {
            viewModel.fetchData()
        }

        viewModel.data.observe(viewLifecycleOwner, {
            binding.dataTxt.text = it
        })
    }
}