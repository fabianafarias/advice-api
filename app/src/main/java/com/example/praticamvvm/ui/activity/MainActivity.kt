package com.example.praticamvvm.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.praticamvvm.R
import com.example.praticamvvm.ui.viewmodel.AdviceViewModel
import com.example.praticamvvm.ui.viewmodel.AdviceViewModelStatus
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val adviceViewModel : AdviceViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewModel()



    }



    fun observeViewModel(){
        adviceViewModel.adviceList.observe(this) {
            when(it){
                is AdviceViewModelStatus.Success -> {
                    Log.d("advice", "$it.adviceData")
                }
                is AdviceViewModelStatus.Error -> TODO()
            }
        }
    }

}











