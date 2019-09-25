package com.recipeexplorer.viewmodel

import androidx.lifecycle.MutableLiveData
import com.recipeexplorer.vo.Recipe

class RecipeViewModel {

    private val title = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()


    fun bind(data:Recipe) {
        imageUrl.value =  data.fullUrl
        title.value = "Title: " + data.title
    }

    fun getTitle() = title
    fun getImageUrl() = imageUrl
}