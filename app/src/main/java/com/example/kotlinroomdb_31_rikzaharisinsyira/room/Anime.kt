package com.example.kotlinroomdb_31_rikzaharisinsyira.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Anime (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tittle: String,
    val desc: String
        )