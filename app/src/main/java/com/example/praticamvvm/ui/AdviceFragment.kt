package com.example.praticamvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.praticamvvm.databinding.FragmentAdviceBinding
import com.example.praticamvvm.model.AdviceViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class AdviceFragment : Fragment() {

    private val viewModel : ViewModel by inject()
    private lateinit var binding: FragmentAdviceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdviceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAdviceText()
        changeAdvice()
    }

    private fun getAdviceText(){
        lifecycleScope.launch {
            viewModel.getAdvice()
        }
    }

    private fun changeAdvice(){
        binding.btnChangeAdvice.setOnClickListener {
            viewModel.adviceList.observe( viewLifecycleOwner) { listAdviceViewModel ->
                populateAdviceTextView(listAdviceViewModel)
            }
        }
    }

    private fun populateAdviceTextView(advices: List<AdviceViewModel>){
        advices.forEach {
            val advice = it.advice
            binding.textView.text = advice
        }
    }
}