package com.vivvy.tech.di.app

import com.recipeexplorer.ui.detail.DetailFragment
import com.recipeexplorer.ui.list.ListFragment
import com.recipeexplorer.RecipeApp
import com.recipeexplorer.di.app.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(target: RecipeApp)
    fun inject(target: ListFragment)
    fun inject(target: DetailFragment)
}