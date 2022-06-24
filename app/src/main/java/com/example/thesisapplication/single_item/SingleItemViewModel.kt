package com.example.thesisapplication.single_item

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thesisapplication.network.RecipeProperty

class SingleItemViewModel(recipeProperty: RecipeProperty, app: Application) : AndroidViewModel(app) {

    private val _selectedRecipe = MutableLiveData<RecipeProperty>()
    val selectedRecipe: LiveData<RecipeProperty>
        get() = _selectedRecipe

    init {
        _selectedRecipe.value = recipeProperty
    }



}