package com.recipeexplorer.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.recipeexplorer.RecipeApp

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as RecipeApp).appComponent.inject(this)
    }
}