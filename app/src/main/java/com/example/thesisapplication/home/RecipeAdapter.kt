package com.example.thesisapplication.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisapplication.databinding.RecipePropertyFragmentBinding
import com.example.thesisapplication.network.RecipeProperty

class RecipeAdapter : ListAdapter<RecipeProperty, RecipeAdapter.RecipeViewHolder>(DiffCallback) {

    class RecipeViewHolder(private var binding: RecipePropertyFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: RecipeProperty) {
            binding.recipe = recipe
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<RecipeProperty>() {
        override fun areItemsTheSame(oldItem: RecipeProperty, newItem: RecipeProperty): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RecipeProperty, newItem: RecipeProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            RecipePropertyFragmentBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
    }
}