package com.example.praticamvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.praticamvvm.R
import com.example.praticamvvm.databinding.AdviceFragmentBinding
import com.example.praticamvvm.ui.viewmodel.AdviceViewModel
import com.example.praticamvvm.ui.viewmodel.AdviceViewModelResult
import org.koin.android.ext.android.inject

class AdviceFragment : Fragment() {

    private lateinit var binding: AdviceFragmentBinding
    private val adviceViewModel: AdviceViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = AdviceFragmentBinding
            .inflate(
                inflater,
                container,
                false
            )
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAdvice()
        updateAdviceState()
        setupChangeAdviceButton()
    }


    private fun observeAdvice(){
        adviceViewModel.adviceList.observe(viewLifecycleOwner){
            when(it){
                is AdviceViewModelResult.Error -> {
                    binding.adviceText.text = getString(R.string.message_error)
                }
                is AdviceViewModelResult.Success -> {
                    val adviceView = it.adviceDataDTO
                    binding.adviceText.text = adviceView.advice
                }
            }
        }

    }

    private fun updateAdviceState(){
        adviceViewModel.adviceUpdate()
    }

    private fun setupChangeAdviceButton(){
        binding.btnChangeAdvice.setOnClickListener {
            adviceViewModel.adviceUpdate()
        }
    }
}