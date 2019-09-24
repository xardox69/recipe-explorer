package com.recipeexplorer.data.repo

import com.contentful.java.cda.CDAAsset
import com.contentful.java.cda.CDAEntry
import com.recipeexplorer.data.entity.RecipeEntity
import com.recipeexplorer.data.source.remote.IRemote
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class Repository(private val remoteSource: IRemote) :
    IRepository {
    override fun getRecipes() :Flowable<MutableList<RecipeEntity>>? {
      return remoteSource.getRecipes()?.subscribeOn(Schedulers.io())
          ?.map {
              val list = mutableListOf<RecipeEntity>()
          for (item in it.items()){
              list.add(
                  RecipeEntity(
                      (item as CDAEntry).id(), item.getField<String>("title"),
                      item.getField<CDAAsset>("photo").url())
              )
          }
          list
      }
    }

    override fun getRecipe(id: String) {

    }

}