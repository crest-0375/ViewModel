package com.practice.viewmodel.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.practice.viewmodel.activity.MainActivity
import com.practice.viewmodel.databinding.FragmentHomeBinding
import com.practice.viewmodel.viewmodel.DataViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DataViewModel

    init {
        Log.d("TAG", "HomeFragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider((activity as MainActivity))[DataViewModel::class.java]
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = viewModel.message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}