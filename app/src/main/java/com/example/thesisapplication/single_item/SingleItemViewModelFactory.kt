package com.example.thesisapplication.single_item

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thesisapplication.network.RecipeProperty
import java.lang.IllegalArgumentException

class SingleItemViewModelFactory(
    private val recipe: RecipeProperty,
    private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SingleItemViewModel::class.java)){
            return SingleItemViewModel(recipe, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}