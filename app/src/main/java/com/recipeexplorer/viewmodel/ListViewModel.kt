package com.recipeexplorer.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import com.recipeexplorer.data.repo.IRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ListViewModel @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val repo: IRepository?): ViewModel() {

    private  var subscription: Disposable? = null


    fun getRecipes(){
        repo?.getRecipes()?.subscribe ()
    }



    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }




}