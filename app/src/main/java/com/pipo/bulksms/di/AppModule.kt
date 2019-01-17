package com.pipo.bible.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.pipo.bulksms.data.db.LocalDataBase
import com.pipo.bulksms.data.repository.LocalRepository
import com.pipo.bulksms.data.repository.LocalRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Philip on 12/01/2018.
 */
@Module
class AppModule {



    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

        @Provides
        @Singleton
        fun  providesLocalDatabase(application: Application): LocalDataBase =
                Room.databaseBuilder(application.applicationContext,
                        LocalDataBase::class.java,
                        LocalDataBase.DB_NAME)
                        .build()




            @Provides
            @Singleton
            fun  provideLocalRepository(localDB: LocalDataBase): LocalRepository = LocalRepositoryImpl(localDB)
//            @Provides

}
