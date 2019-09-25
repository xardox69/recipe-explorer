package com.recipeexplorer.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recipeexplorer.data.repo.IRepository
import com.recipeexplorer.vo.GetRecipesStatus
import com.recipeexplorer.vo.Status
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ListViewModel @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val repo: IRepository?): ViewModel() {

    private  var subscription: Disposable? = null

    val results : LiveData<GetRecipesStatus>
        get() = _results
    private val _results = MutableLiveData<GetRecipesStatus>()


    fun getRecipes(){
        subscription = repo?.getRecipes()?.doOnNext{
            _results.postValue(GetRecipesStatus(Status.SUCCESS,it))
        }
            ?.doOnError {
                it.printStackTrace()
                _results.postValue(GetRecipesStatus(Status.ERROR,null))
            }
            ?.doOnSubscribe { _results.postValue(GetRecipesStatus(Status.LOADING,null)) }
            ?.subscribe()
    }



    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }




}