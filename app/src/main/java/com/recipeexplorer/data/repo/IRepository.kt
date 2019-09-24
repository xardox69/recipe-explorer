package com.recipeexplorer.data.repo

import com.recipeexplorer.data.entity.RecipeEntity
import com.recipeexplorer.vo.Recipe
import io.reactivex.Flowable

interface IRepository {

    fun getRecipes(): Flowable<MutableList<Recipe>>?

    fun getRecipe(id:String)
}