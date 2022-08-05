package com.example.praticamvvm.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.praticamvvm.R
import com.example.praticamvvm.repository.AdviceRepository
import com.example.praticamvvm.repository.AdviceRepositoryStatus
import com.example.praticamvvm.ui.viewmodel.AdviceViewModel
import com.example.praticamvvm.ui.viewmodel.AdviceViewModelStatus
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val adviceViewModel : AdviceViewModel by inject()
//    private val repository : AdviceRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewModel()
        adviceViewModel.adviceUpdate()

//       lifecycleScope.launch {
//           val result = repository.getAdvice()
//           when(result){
//               AdviceRepositoryStatus.Error -> {}
//               is AdviceRepositoryStatus.Success -> {}
//           }
//       }



    }

    fun observeViewModel(){
        adviceViewModel.adviceList.observe(this) {
            when(it){
                is AdviceViewModelStatus.Success -> {
                    val advice = it.adviceData
                    Log.d("adviceViewModel","$advice")
                }
                is AdviceViewModelStatus.Error -> {
                    Log.d("adviceViewModel","Error")
                }
            }
        }
    }


}











