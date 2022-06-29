package com.example.thesisapplication.account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thesisapplication.account.tablayout.FavoriteRecipesFragment
import com.example.thesisapplication.account.tablayout.MyReviewsFragment
import com.example.thesisapplication.account.tablayout.SavedRecipesFragment
import com.example.thesisapplication.account.tablayout.TabAdapter
import com.example.thesisapplication.databinding.AccountFragmentBinding

class AccountFragment : Fragment() {

    private val viewModel: AccountViewModel by lazy {
        ViewModelProvider(this)[AccountViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = AccountFragmentBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.viewPager.adapter = setupTabs()
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        return binding.root
    }


    private fun setupTabs(): TabAdapter {
        val adapter = TabAdapter(childFragmentManager)
        adapter.addFragment(FavoriteRecipesFragment(), "Favorites")
        adapter.addFragment(SavedRecipesFragment(), "Saved")
        adapter.addFragment(MyReviewsFragment(), "My Reviews")
        return adapter
    }

}