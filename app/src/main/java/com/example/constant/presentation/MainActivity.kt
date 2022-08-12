package com.example.constant.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.constant.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerForMovies, MoviesFragment())
            .commit()
    }
}