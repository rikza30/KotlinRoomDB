package com.example.kotlinroomdb_31_rikzaharisinsyira.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Anime::class],
    version = 1
)
abstract class AnimeDB : RoomDatabase(){

    abstract fun  animeDao() : AnimeDao

    companion object{

        @Volatile private var instance : AnimeDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AnimeDB::class.java,
            "anime1234.db"
        ).build()
    }
}