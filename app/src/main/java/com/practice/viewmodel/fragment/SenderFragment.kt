package com.practice.viewmodel.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.practice.viewmodel.R
import com.practice.viewmodel.activity.MainActivity
import com.practice.viewmodel.databinding.FragmentSenderBinding
import com.practice.viewmodel.viewmodel.DataViewModel


class SenderFragment : Fragment() {

    private var _binding: FragmentSenderBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DataViewModel
    init {
        Log.d("TAG", "SenderFragment")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSenderBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider((activity as MainActivity))[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
//            val text = binding.editTextText.text.toString().trim()
//            viewModel.sendMessage(text)
            findNavController().navigate(R.id.action_senderFragment_to_reciverFragment)
        }
        binding.editTextText.doOnTextChanged { text, _, _, _ ->
            viewModel.sendMessage(text.toString())
            binding.textView.text = viewModel.message
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}