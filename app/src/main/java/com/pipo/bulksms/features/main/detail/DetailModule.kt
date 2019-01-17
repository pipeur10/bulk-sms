package com.pipo.bulksms.features.main.detail

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
class DetailModule{
    @Provides
    fun providesViewModelModel(localRepository: LocalRepository):  DetailViewModel= DetailViewModel(localRepository)

    @Provides
    fun providesViewModelProvider(viewModel: DetailViewModel):  ViewModelProvider.Factory= ViewModelProviderFactory(viewModel)
}