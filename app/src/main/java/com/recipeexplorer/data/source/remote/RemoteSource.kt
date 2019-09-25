package com.recipeexplorer.data.source.remote

import android.annotation.SuppressLint
import com.contentful.java.cda.*
import io.reactivex.Flowable


class RemoteSource(val client: CDAClient) :IRemote {
    @SuppressLint("CheckResult")
    override fun getRecipes(): Flowable<CDAArray>? {
       return  client
            .observe(CDAEntry::class.java)
            .where("content_type", "recipe")
            .all()
    }

    override fun getRecipe(id: String) {
    }
}