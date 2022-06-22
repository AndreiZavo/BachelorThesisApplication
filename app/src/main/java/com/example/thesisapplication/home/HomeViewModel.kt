package com.example.thesisapplication.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesisapplication.network.RecipeApi
import com.example.thesisapplication.network.RecipeProperty
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _recipes = MutableLiveData<List<RecipeProperty>>()
    val recipes : LiveData<List<RecipeProperty>>
        get() = _recipes

//    private val _underThirtyRecipes = MutableLiveData<List<RecipeProperty>>()
//    val underThirtyRecipes: LiveData<List<RecipeProperty>>
//        get() = _underThirtyRecipes

    private val _status = MutableLiveData<String>()
    val status : LiveData<String>
        get() = _status

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch {
            try{
                val listResult = RecipeApi.retrofitService.getRecipes()
                //val underThirtyListResult = RecipeApi.retrofitService.getRecipesByMinutes(30)
                if(listResult.isNotEmpty()){
                    _recipes.value = listResult
                    //_underThirtyRecipes.value = underThirtyListResult
                    _status.value = "Success ${listResult.size} fetched"
                }
                else{
                    _status.value = "Internal code error"
                    throw Exception("Lists has problems")
                }
            } catch (e: Exception){
                _recipes.value = ArrayList()
                //_underThirtyRecipes.value = ArrayList()
                _status.value = e.message
            }
        }
    }

}