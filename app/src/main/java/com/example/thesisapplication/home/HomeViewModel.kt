package com.example.thesisapplication.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesisapplication.network.RecipeApi
import com.example.thesisapplication.network.RecipeProperty
import kotlinx.coroutines.launch

enum class RecipeApiStatus { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel() {

    private val _recipes = MutableLiveData<List<RecipeProperty>>()
    val recipes: LiveData<List<RecipeProperty>>
        get() = _recipes

//    private val _underThirtyRecipes = MutableLiveData<List<RecipeProperty>>()
//    val underThirtyRecipes: LiveData<List<RecipeProperty>>
//        get() = _underThirtyRecipes

    private val _status = MutableLiveData<RecipeApiStatus>()
    val status: LiveData<RecipeApiStatus>
        get() = _status

    private val _navigateToSelectedRecipe = MutableLiveData<RecipeProperty?>()
    val navigateToSelectedRecipe : LiveData<RecipeProperty?>
        get() = _navigateToSelectedRecipe

    private val _errorText = MutableLiveData<String>()
    val errorText : LiveData<String>
        get() = _errorText

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch {
            try {
                _status.value = RecipeApiStatus.LOADING
                val listResult = RecipeApi.retrofitService.getRecipes()
                //val underThirtyListResult = RecipeApi.retrofitService.getRecipesByMinutes(30)
                if (listResult.isNotEmpty()) {
                    _recipes.value = listResult
                    //_underThirtyRecipes.value = underThirtyListResult
                    _status.value = RecipeApiStatus.DONE
                } else {
                    throw Exception("Lists has problems")
                }
            } catch (e: Exception) {
                _recipes.value = ArrayList()
                //_underThirtyRecipes.value = ArrayList()
                _status.value = RecipeApiStatus.ERROR
                _errorText.value = e.message
            }
        }
    }

    fun displayRecipeDetails(recipeProperty: RecipeProperty){
        _navigateToSelectedRecipe.value = recipeProperty
    }

    fun displayRecipeDetailsComplete(){
        _navigateToSelectedRecipe.value = null
    }

}