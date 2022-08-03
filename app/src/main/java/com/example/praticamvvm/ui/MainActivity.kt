package com.example.praticamvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.praticamvvm.R
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val adviceViewModel : ViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        textView.setOnClickListener {
            adviceViewModel.adviceList.observe(this) {
                getAdvice()
                it?.forEach {adviceModel ->
                    textView.text = adviceModel.advice
                }
            }
        }
    }

    private fun getAdvice(){
        lifecycleScope.launch {
            adviceViewModel.getAdvice()
        }
    }

}


