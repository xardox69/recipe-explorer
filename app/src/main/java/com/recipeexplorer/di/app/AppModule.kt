package com.recipeexplorer.di.app

import android.app.Application
import android.content.Context
import com.contentful.java.cda.CDAClient
import com.recipeexplorer.data.repo.IRepository
import com.recipeexplorer.data.repo.Repository
import com.recipeexplorer.data.source.remote.IRemote
import com.recipeexplorer.data.source.remote.RemoteSource
import com.recipeexplorer.di.ViewModelModule
import com.recipeexplorer.doman.RecipeMapper
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule(private val app: Application) {

    companion object {
        const val AppContext = "app_context"
    }


    @Provides
    @Named(AppContext)
    fun provideContext(): Context = app.applicationContext


    @Provides
    fun provideSubscriberScheduler(): Scheduler = Schedulers.io()

    @Provides
    fun providesContentfulClient(): CDAClient {
       return  CDAClient.builder()
            .setSpace("kk2bw5ojx476")
            .setToken("7ac531648a1b5e1dab6c18b0979f822a5aad0fe5f1109829b8a197eb2be4b84c")
            .build()
    }

    @Provides
    @Singleton
    fun providesRepository(remote:IRemote, recipeMapper: RecipeMapper): IRepository =
        Repository(remote,recipeMapper)

    @Provides
    @Singleton
    fun providesRemoteSource(client:CDAClient):IRemote = RemoteSource(client)

}
