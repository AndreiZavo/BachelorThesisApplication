package com.example.thesisapplication.single_item

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thesisapplication.R

class SingleItemFragment : Fragment() {

    companion object {
        fun newInstance() = SingleItemFragment()
    }

    private lateinit var viewModel: SingleItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.single_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SingleItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}