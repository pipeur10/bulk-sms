package com.pipo.bulksms.features.main

import android.arch.lifecycle.ViewModelProvider
import com.pipo.bible.features.base.ViewModelProviderFactory
import com.pipo.bulksms.data.repository.LocalRepository
import dagger.Module
import dagger.Provides

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:38 PM
 */
@Module
class MainModule {

    @Provides
    fun providesViewModelModel(localRepository: LocalRepository): MainViewModel= MainViewModel(localRepository)

    @Provides
    fun providesViewModelProvider(viewModel: MainViewModel):  ViewModelProvider.Factory= ViewModelProviderFactory(viewModel)
}