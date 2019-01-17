package com.pipo.bible.di


import com.pipo.bulksms.features.main.MainActivity
import com.pipo.bulksms.features.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Philip on 12/01/2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun bindMainActivity(): MainActivity


}
