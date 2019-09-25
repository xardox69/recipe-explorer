package com.recipeexplorer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.recipeexplorer.databinding.RecipeItemBinding
import com.recipeexplorer.viewmodel.RecipeViewModel
import com.recipeexplorer.vo.Recipe

class ListAdapter(val data:MutableList<Recipe>) : RecyclerView.Adapter<ListAdapter.DataViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding: RecipeItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recipe_item, parent, false
        )
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.tag = data[position]
    }

    fun setItems(items: MutableList<Recipe>) {
        data.addAll(items)
        notifyDataSetChanged()
    }


    inner class DataViewHolder(private val binding: RecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = RecipeViewModel()

        fun bind(post: Recipe) {
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }
}