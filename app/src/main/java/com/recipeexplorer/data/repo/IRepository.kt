package com.recipeexplorer.data.repo

import com.recipeexplorer.data.entity.RecipeEntity
import io.reactivex.Flowable

interface IRepository {

    fun getRecipes(): Flowable<MutableList<RecipeEntity>>?

    fun getRecipe(id:String)
}