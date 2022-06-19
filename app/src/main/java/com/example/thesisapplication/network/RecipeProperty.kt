package com.example.thesisapplication.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class RecipeProperty(
    val id: Int,
    val name: String,
    val tags: String,
    val description: String,
    val nutrition: String,
    val ingredients: String,
    val num_of_ingredients: Int,
    val minutes: Int,
    val num_of_steps: Int,
    val steps: String
) : Parcelable {
}