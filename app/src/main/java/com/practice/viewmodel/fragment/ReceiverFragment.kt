package com.practice.viewmodel.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.practice.viewmodel.activity.MainActivity
import com.practice.viewmodel.databinding.FragmentReciverBinding
import com.practice.viewmodel.viewmodel.DataViewModel

class ReceiverFragment : Fragment() {
    private var _binding: FragmentReciverBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DataViewModel
    init {
        Log.d("TAG", "ReceiverFragment")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReciverBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider((activity as MainActivity))[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reciverTextView.text = viewModel.message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}