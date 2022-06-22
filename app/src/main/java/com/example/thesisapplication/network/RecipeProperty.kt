package com.example.thesisapplication.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class RecipeProperty(
    val recipe_id: Int,
    val name: String,
    val tags: String,
    val description: String,
    val nutrition: String,
    val ingredients: String,
    val n_ingredients: Int,
    val minutes: Int,
    val n_steps: Int,
    val steps: String
) : Parcelable {
}