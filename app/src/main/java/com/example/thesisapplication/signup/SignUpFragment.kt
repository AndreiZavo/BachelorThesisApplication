package com.example.thesisapplication.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.thesisapplication.R
import com.example.thesisapplication.databinding.SignUpBinding
import com.example.thesisapplication.login.LogInViewModel

class SignUp : Fragment() {

    private val viewModel: SignUpViewModel by lazy {
        ViewModelProvider(this)[SignUpViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = SignUpBinding.inflate(inflater)
        binding.viewModel = viewModel
        setHasOptionsMenu(true)

        viewModel.navigateToLogIn.observe(viewLifecycleOwner,
            Observer { shouldNavigate ->
                if(shouldNavigate == true){
                    val navController = binding.root.findNavController()
                    navController.navigate(R.id.action_signUp_to_logIn)
                    viewModel.onLogInLinkNavigated()
                }

            })

        return binding.root
    }



}