package com.example.musicplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer.databinding.FragmentPlaylistBinding

class PlaylistFragment : Fragment() {
    private var songAdapter: SongAdapter? = null
    private var _binding: FragmentPlaylistBinding? = null
    private val binding get() = _binding!!
    private val dataBase: DataBase = DataBase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (dataBase.getList().isEmpty()) {
            dataBase.makeList()
        }
        songAdapter = SongAdapter()
        songAdapter?.setOnSongClickListener(object :
            SongAdapter.OnSongClickListener {
            override fun onSongClick(position: Int, song: Song) {
                val fragment = SingerFragment.newInstance(
                    song.name, song.singer
                )
                (activity as MainActivity).navigateToSingerFragment(fragment)
            }
        })
        binding.recyclerView.adapter = songAdapter
    }

    override fun onResume() {
        super.onResume()
        showSongs()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun showSongs() {
        songAdapter?.setListOfSongs(dataBase.getList())
    }

}