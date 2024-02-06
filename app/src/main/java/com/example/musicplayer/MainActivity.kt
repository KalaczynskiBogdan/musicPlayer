package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var imageHome: ImageView
    private lateinit var imageSettings: ImageView
    private lateinit var playlistFragment: PlaylistFragment
    private lateinit var singerFragment: SingerFragment
    private lateinit var settingsFragment: SettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initFragments()
        navigateToPlaylistFragment()
        clickOnItems()
        clickOnItemsToolbar()
    }

    private fun initViews() {
        bottomNavigation = findViewById(R.id.bnv)
        imageHome = findViewById(R.id.btnHome)
        imageSettings = findViewById(R.id.btnSettings)
    }

    private fun initFragments() {
        playlistFragment = PlaylistFragment()
        singerFragment = SingerFragment()
        settingsFragment = SettingsFragment()
    }

    private fun navigateToPlaylistFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, playlistFragment)
            .commit()
    }

    fun navigateToSingerFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun navigateToSettingsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, settingsFragment)
            .commit()
    }

    private fun clickOnItems() {
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.playlist -> {
                    navigateToPlaylistFragment()
                    true
                }

                R.id.singer -> {
                    navigateToSingerFragment(singerFragment)
                    true
                }

                R.id.settings -> {
                    navigateToSettingsFragment()
                    true
                }

                else ->
                    false
            }
        }
    }

    private fun clickOnItemsToolbar() {
        imageHome.setOnClickListener {
            navigateToPlaylistFragment()
        }
        imageSettings.setOnClickListener {
            navigateToSettingsFragment()
        }
    }
}