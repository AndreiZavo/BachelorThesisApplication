package com.example.thesisapplication.single_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesisapplication.databinding.SingleItemFragmentBinding

class SingleItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(activity).application
        val binding = SingleItemFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val recipe = SingleItemFragmentArgs.fromBundle(requireArguments()).selectedRecipe
        val viewModelFactory = SingleItemViewModelFactory(recipe, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory)[SingleItemViewModel::class.java]

        return binding.root
    }


}