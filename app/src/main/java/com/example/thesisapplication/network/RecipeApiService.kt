package com.example.thesisapplication.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


private const val BASE_URL = "http://10.0.2.2:8000/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val okHttpClient = OkHttpClient.Builder()
    .callTimeout(5, TimeUnit.MINUTES)
    .connectTimeout(1, TimeUnit.MINUTES)
    .writeTimeout(1, TimeUnit.MINUTES)
    .readTimeout(1, TimeUnit.MINUTES)
    .build()

private val retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RecipeApiService {

    @GET("recipes")
    suspend fun getRecipes(): List<RecipeProperty>

    @GET("get_recipe/{recipe_id}")
    suspend fun getRecipe(@Path("recipe_id") recipe_id: Int): RecipeProperty

    @GET("get-by-minutes")
    suspend fun getRecipesByMinutes(@Query("minutes") minutes: Int) : List<RecipeProperty>

    @GET("get-by-name")
    suspend fun getRecipesByName(@Query("name") name: String): List<RecipeProperty>

    @GET("get_content_based_recommendation/{appreciated_recipe_id}")
    suspend fun getContentBasedRecommendedRecipes(@Path("appreciated_recipe_id") recipe_id: Int) : List<RecipeProperty>


}

object RecipeApi{
    val retrofitService : RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }
}