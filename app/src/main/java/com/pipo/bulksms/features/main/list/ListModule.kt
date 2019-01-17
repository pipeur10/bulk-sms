package com.pipo.bulksms.features.main.list

import android.arch.lifecycle.ViewModelProvider
import com.pipo.bible.features.base.ViewModelProviderFactory
import com.pipo.bulksms.data.repository.LocalRepository
import dagger.Module
import dagger.Provides

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:49 PM
 */
@Module
class ListModule{
    @Provides
    fun providesViewModelModel(localRepository: LocalRepository): ListViewModel= ListViewModel(localRepository)

    @Provides
    fun providesViewModelProvider(viewModel: ListViewModel):  ViewModelProvider.Factory= ViewModelProviderFactory(viewModel)
}