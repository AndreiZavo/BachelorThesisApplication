package com.example.thesisapplication.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.SystemClock.sleep
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.thesisapplication.R
import com.example.thesisapplication.databinding.HomeFragmentBinding
import com.example.thesisapplication.network.RecipeApi
import com.example.thesisapplication.network.RecipeProperty
import com.google.android.gms.tasks.Tasks.await
import kotlinx.coroutines.delay
import retrofit2.Retrofit

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = HomeFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.recommendendedRecipeList.adapter = RecipeAdapter(RecipeAdapter.OnClickListener {
            viewModel.displayRecipeDetails(it)
        })

        viewModel.navigateToSelectedRecipe.observe(viewLifecycleOwner, Observer {
            if(null != it){
                this.findNavController().navigate(HomeFragmentDirections
                    .actionHomeFragmentToSingleItemFragment(it))
                viewModel.displayRecipeDetailsComplete()
            }
        })

        binding.recommendationCategoryTextview.setOnClickListener {
            viewModel.getRecommendedRecipes()
            binding.recommendationCategoryTextview.text =
                "Based on your recent likes, we\nthink you might like these:"
        }

        setHasOptionsMenu(true)

        return binding.root
    }
}