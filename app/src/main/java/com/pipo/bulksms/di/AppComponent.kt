package com.pipo.bible.di

import android.app.Application
import com.pipo.bulksms.CustomApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Philip on 03/12/2017.
 */
@Singleton
@Component(modules= [AppModule::class,
    AndroidInjectionModule::class,
    ActivityBuilder::class,
    ServiceBuilder::class,
    FragmentBuilder::class,
    ReceiverBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: CustomApplication)
}