package com.example.thesisapplication

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisapplication.home.RecipeAdapter
import com.example.thesisapplication.home.RecipeApiStatus
import com.example.thesisapplication.network.RecipeProperty
import com.example.thesisapplication.search.SearchRecipeAdapter

@BindingAdapter("listData")
fun bindRecycleView(recyclerView: RecyclerView, data: List<RecipeProperty>?){
    val adapter = recyclerView.adapter as RecipeAdapter
    adapter.submitList(data)
}

@BindingAdapter("searchListData")
fun bindSearchRecycleView(recyclerView: RecyclerView, data: List<RecipeProperty>?){
    val adapter = recyclerView.adapter as SearchRecipeAdapter
    adapter.submitList(data)
}

@BindingAdapter("recipeApiStatus")
fun bindStatus(statusImageView: ImageView, status: RecipeApiStatus?){
    when(status){
        RecipeApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        RecipeApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        else -> statusImageView.visibility = View.GONE
    }
}