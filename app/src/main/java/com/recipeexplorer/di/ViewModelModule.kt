package com.recipeexplorer.di
import dagger.Binds
import androidx.lifecycle.ViewModel
import com.recipeexplorer.viewmodel.DetailViewModel
import com.recipeexplorer.viewmodel.ListViewModel
import com.vivvy.tech.di.ViewModelKey
import dagger.Module
import dagger.multibindings.IntoMap



@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindMainModel(mainViewModel: ListViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(loginViewModel: DetailViewModel): ViewModel


}