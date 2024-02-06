package com.example.musicplayer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer.databinding.FragmentSingerBinding

class SingerFragment : Fragment() {
    private var name: String? = null
    private var singer: String? = null
    private val dataBase: DataBase = DataBase.getInstance()
    private var _binding: FragmentSingerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInfo()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    @SuppressLint("SetTextI18n")
    private fun showInfo() {
        if (arguments != null) {
            arguments?.let {
                name = it.getString(SONG_NAME)
                singer = it.getString(SONG_SINGER)
            }
            binding.tvSongName.text = name
            binding.tvSingerName.text = singer
            val newName:String = name.toString()
            val newSinger: String = singer.toString()
            dataBase.saveLastSong(newName,newSinger)
        }
         else {
            binding.tvSongName.text = dataBase.getLastSongName()
            binding.tvSingerName.text = dataBase.getLastSongSinger()
        }
    }

    companion object {
        private const val SONG_NAME = "name"
        private const val SONG_SINGER = "singer"
        fun newInstance(name: String, singer: String) = SingerFragment().apply {
            arguments = Bundle().apply {
                putString(SONG_NAME, name)
                putString(SONG_SINGER, singer)
            }
        }
    }
}