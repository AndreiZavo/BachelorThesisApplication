package com.example.thesisapplication.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisapplication.databinding.RecipePropertyFragmentBinding
import com.example.thesisapplication.databinding.SearchItemBinding
import com.example.thesisapplication.home.RecipeAdapter
import com.example.thesisapplication.network.RecipeProperty

class SearchRecipeAdapter: ListAdapter<RecipeProperty, SearchRecipeAdapter.RecipeViewHolder>(DiffCallback) {

    class RecipeViewHolder(private var binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: RecipeProperty) {
            binding.recipe = recipe
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<RecipeProperty>() {
        override fun areItemsTheSame(oldItem: RecipeProperty, newItem: RecipeProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RecipeProperty, newItem: RecipeProperty): Boolean {
            return oldItem.recipe_id == newItem.recipe_id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            SearchItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
    }
}
