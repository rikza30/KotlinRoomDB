package com.example.kotlinroomdb_31_rikzaharisinsyira.room

import androidx.room.*

@Dao
interface AnimeDao {

    @Insert
    suspend fun addAnime(anime: Anime)

    @Update
    suspend fun updateAnime(anime: Anime)

    @Delete
    suspend fun DeleteAnime(anime: Anime)

    @Query ("SELECT * FROM anime")
    suspend fun getAnime():List<Anime>
}