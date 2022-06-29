package com.example.thesisapplication.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesisapplication.network.RecipeApi
import com.example.thesisapplication.network.RecipeProperty
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _searchRecipeList = MutableLiveData<List<RecipeProperty>>()
    val searchRecipeList : LiveData<List<RecipeProperty>>
        get() = _searchRecipeList

    private val _navigateToSelectedRecipe = MutableLiveData<RecipeProperty?>()
    val navigateToSelectedRecipe : LiveData<RecipeProperty?>
        get() = _navigateToSelectedRecipe

    init {
        getSearchRecipes()
    }

    private fun getSearchRecipes(){
        viewModelScope.launch {
            try{
                val listResult = RecipeApi.retrofitService.getRecipes()
                if(listResult.isNotEmpty()){
                    _searchRecipeList.value = listResult
                }
                else{
                    throw Exception("List has a problem")
                }
            }catch (e: Exception){
                _searchRecipeList.value = ArrayList()
            }
        }
    }

    fun getSearchedRecipesByName(name: String){
        viewModelScope.launch {
            val listResult = RecipeApi.retrofitService.getRecipesByName(name)
            if (listResult.isNotEmpty()){
                _searchRecipeList.value = listResult
            }
            else{
                throw Exception("List has a search problem")
            }
        }
    }

    fun displaySelectedRecipe(recipeProperty: RecipeProperty){
        _navigateToSelectedRecipe.value = recipeProperty
    }

    fun displaySelectedRecipeCompleted(){
        _navigateToSelectedRecipe.value = null
    }


}