package com.dangbei.android_hilt.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Log::class), version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){

    abstract fun  logDao() : LogDao

}