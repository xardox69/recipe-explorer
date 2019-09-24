package com.recipeexplorer.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.contentful.java.cda.*
import io.reactivex.Flowable
import org.reactivestreams.Subscriber
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription
import java.util.Collections.singletonList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import java.util.*


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