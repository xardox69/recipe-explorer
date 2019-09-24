package com.recipeexplorer.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import com.recipeexplorer.data.repo.IRepository
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val repo: IRepository?): ViewModel() {
}