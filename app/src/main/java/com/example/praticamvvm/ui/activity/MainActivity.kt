package com.example.praticamvvm.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.praticamvvm.R
import com.example.praticamvvm.ui.viewmodel.AdviceViewModel
import com.example.praticamvvm.ui.viewmodel.AdviceViewModelStatus
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val adviceViewModel: AdviceViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = this.findViewById(R.id.adviceText)
        val btn: Button = this.findViewById(R.id.btnChangeAdvice)

        btn.setOnClickListener {
            observeViewModel(textView)
            adviceViewModel.adviceUpdate()
        }
    }

    fun observeViewModel(textView: TextView) {
        adviceViewModel.adviceList.observe(this) {
            when (it) {
                is AdviceViewModelStatus.Success -> {
                    val advice = it.adviceData
                    textView.text = advice.advice
//                    Log.d("adviceViewModel", "$advice")
                }
                is AdviceViewModelStatus.Error -> {
                    textView.text = "Deu ruim!"
//                    Log.d("adviceViewModel", "Error")
                }
            }
        }
    }
}











