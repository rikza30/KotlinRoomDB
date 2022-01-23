package com.example.kotlinroomdb_31_rikzaharisinsyira

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinroomdb_31_rikzaharisinsyira.room.Anime
import com.example.kotlinroomdb_31_rikzaharisinsyira.room.AnimeDB
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Add : AppCompatActivity() {
    val db by lazy {AnimeDB(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupListener()
    }

    fun setupListener(){
        button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.animeDao().addAnime(
                    Anime(0, et_judul.text.toString(),
                    et_deskripsi.text.toString())
                )

                finish()
            }
        }
    }
}