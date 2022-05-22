package com.example.thesisapplication.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.thesisapplication.R
import com.example.thesisapplication.databinding.LogInBinding

class LogInFragment : Fragment() {

    private val viewModel: LogInViewModel by lazy {
        ViewModelProvider(this)[LogInViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding = LogInBinding.inflate(inflater)
        binding.viewModel = viewModel
        setHasOptionsMenu(true)

        viewModel.navigateToSignUp.observe(viewLifecycleOwner,
        Observer<Boolean> { shouldNavigateToSignUp ->
            if(shouldNavigateToSignUp == true){
                val navController = binding.root.findNavController()
                navController.navigate(R.id.action_logIn_to_signUp)
                viewModel.onSignUpLinkNavigated()
            }
        })

        return binding.root
    }

}