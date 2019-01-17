package com.pipo.bible.di

import com.pipo.bulksms.features.main.detail.DetailFragment
import com.pipo.bulksms.features.main.detail.DetailModule
import com.pipo.bulksms.features.main.list.ListFragment
import com.pipo.bulksms.features.main.list.ListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Author: Philip
 * Date: 28/07/2018 at 10:42 AM
 */
@Module
abstract class FragmentBuilder{

    @ContributesAndroidInjector(modules = [ListModule::class])
    internal abstract fun bindListFragment(): ListFragment

    @ContributesAndroidInjector(modules = [DetailModule::class])
    internal abstract fun bindDetailFragment(): DetailFragment

}