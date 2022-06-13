package com.aggressiveclick.formulab.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.aggressiveclick.formulab.R
import com.aggressiveclick.formulab.databinding.FragmentSelectTestBinding

class SelectTestFragment : Fragment() {

    private val viewModel: SelectTestViewModel by viewModels()

    private var _binding: FragmentSelectTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectTestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCategories().observe(viewLifecycleOwner) { list ->
            for (category in list) {
                Log.d("TAG", "onViewCreated: $category")
            }
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}