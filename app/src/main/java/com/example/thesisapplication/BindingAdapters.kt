package com.example.thesisapplication

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisapplication.home.RecipeAdapter
import com.example.thesisapplication.network.RecipeProperty

@BindingAdapter("listData")
fun bindRecycleView(recyclerView: RecyclerView, data: List<RecipeProperty>?){
    val adapter = recyclerView.adapter as RecipeAdapter
    adapter.submitList(data)
}