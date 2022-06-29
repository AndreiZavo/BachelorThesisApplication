package com.example.thesisapplication.single_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesisapplication.R
import com.example.thesisapplication.databinding.SingleItemFragmentBinding
import com.example.thesisapplication.network.RecipeProperty

class SingleItemFragment : Fragment() {

    var pizza: RecipeProperty? = null
    private var likeClicked: Boolean = false
    private var saveClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pizza = arguments?.getParcelable("pizzaTa")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(activity).application
        val binding = SingleItemFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        if(pizza != null){
            val viewModelFactory = SingleItemViewModelFactory(pizza!!, application)
            binding.viewModel = ViewModelProvider(
                this, viewModelFactory)[SingleItemViewModel::class.java]
        }
        else{
            val recipe = SingleItemFragmentArgs.fromBundle(requireArguments()).selectedRecipe
            val viewModelFactory = SingleItemViewModelFactory(recipe, application)
            binding.viewModel = ViewModelProvider(
                this, viewModelFactory)[SingleItemViewModel::class.java]
        }

        binding.likeRecipeBtn.setOnClickListener {
            if(!likeClicked){
                binding.likeRecipeBtn.setImageResource(R.drawable.ic_filled_like)
                likeClicked = true
            }
            else{
                binding.likeRecipeBtn.setImageResource(R.drawable.ic_like)
            }
        }

        binding.saveRecipeBtn.setOnClickListener {
            if(!saveClicked){
                binding.saveRecipeBtn.setImageResource(R.drawable.ic_filled_bookmark)
                saveClicked = true
            }
            else{
                binding.saveRecipeBtn.setImageResource(R.drawable.ic_bookmark)
            }
        }

        return binding.root
    }


}