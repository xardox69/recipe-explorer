package com.recipeexplorer.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.recipeexplorer.R
import com.recipeexplorer.viewmodel.ListViewModel
import com.recipeexplorer.RecipeApp
import com.recipeexplorer.di.ViewModelFactory
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as RecipeApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val v = inflater.inflate(inflater, R.layout.frag_list,container,false)
        val v = inflater.inflate(R.layout.frag_list,container,false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ListViewModel::class.java)



    }

    override fun onResume() {
        super.onResume()
        viewModel.getRecipes()
    }

}