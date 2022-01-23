package com.example.kotlinroomdb_31_rikzaharisinsyira

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinroomdb_31_rikzaharisinsyira.room.AnimeDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val db by lazy { AnimeDB(this) }
    lateinit var animeAdapter: AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val animes = db.animeDao().getAnime()
            Log.d("MainActivity", "dbresponse : $animes")
            withContext(Dispatchers.Main){
                animeAdapter.setData(animes)
            }
        }
    }

    fun setupListener(){
        add_anime.setOnClickListener {
            startActivity(Intent(this, Add::class.java))
        }
    }

    private fun setupRecyclerView(){
        animeAdapter = AnimeAdapter(arrayListOf())
        rv_anime.apply{
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = animeAdapter
        }
    }
}