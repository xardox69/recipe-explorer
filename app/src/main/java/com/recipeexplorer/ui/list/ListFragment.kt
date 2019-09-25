package com.recipeexplorer.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.recipeexplorer.ListAdapter
import com.recipeexplorer.R
import com.recipeexplorer.viewmodel.ListViewModel
import com.recipeexplorer.RecipeApp
import com.recipeexplorer.databinding.FragListBinding
import com.recipeexplorer.di.ViewModelFactory
import com.recipeexplorer.vo.GetRecipesStatus
import com.recipeexplorer.vo.Status
import com.vivvy.tech.util.autoCleared
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ListViewModel
    private lateinit var  binding: FragListBinding
    var adapter by autoCleared<ListAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as RecipeApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.frag_list,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ListViewModel::class.java)
        binding.state = viewModel.results
        initRecyclerView()

        viewModel.results.observe(viewLifecycleOwner, Observer {

            when(it.status){

                Status.SUCCESS->{
                    Log.d("list","success")
                    it.recipes?.let {  recipes->adapter.setItems(recipes)}}
                Status.ERROR->{
                    Log.d("list","error")
                }
                Status.LOADING->{
                    Log.d("list","loading")
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getRecipes()
    }

    private fun initRecyclerView() {
        adapter = ListAdapter(mutableListOf())
        val mDividerItemDecoration = DividerItemDecoration(
            binding.recipeList.context,
            DividerItemDecoration.VERTICAL
        )
        binding.recipeList.addItemDecoration(mDividerItemDecoration)
        binding.recipeList.adapter = adapter
    }




    }