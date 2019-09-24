package com.recipeexplorer

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.recipeexplorer.di.app.AppModule
import com.vivvy.tech.di.app.AppComponent
import com.vivvy.tech.di.app.DaggerAppComponent

class RecipeApp: Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }


    private fun initDagger(app: RecipeApp): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}
