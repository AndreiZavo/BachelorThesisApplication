package com.example.thesisapplication.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.thesisapplication.databinding.SearchFragmentBinding

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this)[SearchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = SearchFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.searchableRecipeList.adapter =
            SearchRecipeAdapter(SearchRecipeAdapter.OnClickListener {
                viewModel.displaySelectedRecipe(it)
            })

        viewModel.navigateToSelectedRecipe.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController()
                    .navigate(SearchFragmentDirections.actionSearchFragmentToSingleItemFragment(it))
                viewModel.displaySelectedRecipeCompleted()
            }
        })

//        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (query != null) {
//                    //binding.viewModel.getSearchedRecipesByName(query)
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//        })



        return binding.root
    }

}

