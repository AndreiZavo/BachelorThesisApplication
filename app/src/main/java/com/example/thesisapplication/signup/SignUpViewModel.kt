package com.example.thesisapplication.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private var _navigateToLogIn = MutableLiveData<Boolean>()
    val navigateToLogIn : LiveData<Boolean>
        get() = _navigateToLogIn

    fun onLogInLink(){
        _navigateToLogIn.value = true
    }

    fun onLogInLinkNavigated(){
        _navigateToLogIn.value = false
    }

}