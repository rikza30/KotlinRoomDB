package com.example.kotlinroomdb_31_rikzaharisinsyira


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinroomdb_31_rikzaharisinsyira.room.Anime
import kotlinx.android.synthetic.main.list_anime.view.*

class AnimeAdapter(private val animes: ArrayList<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_anime, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime  = animes[position]
        holder.view.text_title.text = anime.tittle
    }

    override fun getItemCount() = animes.size

    class AnimeViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Anime>){
        animes.clear()
        animes.addAll(list)
        notifyDataSetChanged()
    }
}