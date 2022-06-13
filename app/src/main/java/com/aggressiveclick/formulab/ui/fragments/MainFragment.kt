package com.aggressiveclick.formulab.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aggressiveclick.formulab.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.aboutUsBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAboutFragment())
        }

        binding.contactBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToContactFragment())
        }

        binding.testoviBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSelectTestFragment())
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}