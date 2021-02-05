package com.dangbei.android_hilt.di

import android.content.Context
import androidx.room.Room
import com.dangbei.android_hilt.data.AppDataBase
import com.dangbei.android_hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) : AppDataBase {
        return Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "logging.db"
        ).build()
    }

    @Provides
    fun provideLogDao(dataBase: AppDataBase) : LogDao{
        return dataBase.logDao()
    }
}