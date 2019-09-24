package com.recipeexplorer.data.source.remote

import com.contentful.java.cda.CDAArray
import io.reactivex.Flowable

interface IRemote {

    fun getRecipes() : Flowable<CDAArray>?

    fun getRecipe(id:String)

}