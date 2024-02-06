package com.example.musicplayer

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    private var listOfSongs: ArrayList<Song> = ArrayList()
    private lateinit var onSongClickListener: OnSongClickListener

    fun setOnSongClickListener(onSongClickListener: OnSongClickListener) {
        this.onSongClickListener = onSongClickListener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListOfSongs(listOfSongs: ArrayList<Song>) {
        this.listOfSongs = listOfSongs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.song_item, parent, false
        )
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SongViewHolder, position: Int) {
        val song = listOfSongs[position]
        val text1 = song.name
        val text2 = song.singer
        viewHolder.textViewSongs.text = text1
        viewHolder.textViewSingers.text = text2
        viewHolder.itemView.setOnClickListener {
            onSongClickListener.onSongClick(position, song)
        }
    }

    override fun getItemCount(): Int {
        return listOfSongs.size
    }

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewSongs: TextView = itemView.findViewById(R.id.tvSong)
        val textViewSingers: TextView = itemView.findViewById(R.id.tvSinger)
    }

    interface OnSongClickListener {
        fun onSongClick(position: Int, song: Song)
    }
}