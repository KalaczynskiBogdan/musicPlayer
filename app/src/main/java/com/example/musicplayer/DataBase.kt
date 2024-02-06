package com.example.musicplayer

class DataBase {
    private var name: String = "Radioactive"
    private var singer: String = "Imagine Dragons"
    private val listOfSongs: ArrayList<Song> = ArrayList()

    companion object {
        private var instance: DataBase? = null
        fun getInstance(): DataBase {
            if (instance == null) {
                instance = DataBase()
            }
            return instance as DataBase
        }
    }

    fun makeList() {
        listOfSongs.add(Song("Radioactive", "Imagine Dragons"))
        listOfSongs.add(Song("Dior", "Pop Smoke"))
        listOfSongs.add(Song("Holiday", "Lil nas x"))
        listOfSongs.add(Song("Highest in the room", "Travis Scott"))
        listOfSongs.add(Song("Blue lights", "Jorja Smith"))
        listOfSongs.add(Song("Doja", "Central Cee"))
    }

    fun getList(): ArrayList<Song> {
        return ArrayList(listOfSongs)
    }

    fun saveLastSong(name: String, singer: String) {
        this.name = name
        this.singer = singer
    }

    fun getLastSongName(): String {
        return name
    }

    fun getLastSongSinger(): String {
        return singer
    }
}