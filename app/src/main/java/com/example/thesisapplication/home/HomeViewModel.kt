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

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch {
            try{
                val listResult = RecipeApi.retrofitService.getRecipes()
                if(listResult.isNotEmpty()){
                    _recipes.value = listResult
                    _response.value = "Success: ${listResult.size} recipes retrieved"
                }
                else{
                    _response.value = "Something bad happened"
                    throw Exception("List has problems")
                }
            } catch (e: Exception){
                _recipes.value = ArrayList()
                _response.value = e.message
            }
        }
    }

}