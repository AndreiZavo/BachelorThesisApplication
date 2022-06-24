package com.example.thesisapplication.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.thesisapplication.R
import com.example.thesisapplication.databinding.HomeFragmentBinding

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

        setHasOptionsMenu(true)

        return binding.root
    }

}