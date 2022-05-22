package com.example.thesisapplication.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogInViewModel : ViewModel() {

    private var _navigateToSignUp = MutableLiveData<Boolean>()
    val navigateToSignUp : LiveData<Boolean>
        get() = _navigateToSignUp

    fun onSignUpLink(){
        _navigateToSignUp.value = true
    }

    fun onSignUpLinkNavigated(){
        _navigateToSignUp.value = false
    }
}