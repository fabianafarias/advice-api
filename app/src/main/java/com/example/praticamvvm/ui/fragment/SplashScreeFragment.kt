package com.example.praticamvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.praticamvvm.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TIME_SPLASH_SCREEN: Long = 3000

class SplashScreeFragment : Fragment() {

    private val navController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.splash_screen_fragment,
            container,
            false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(TIME_SPLASH_SCREEN)
            val directions = SplashScreeFragmentDirections
                .actionSplashScreeFragmentToAdviceFragment()
            navController.navigate(directions)
        }
    }


}