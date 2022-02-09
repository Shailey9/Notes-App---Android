package com.example.mynotes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_splash)

        CoroutineScope(Dispatchers.Main).launch {
            delay(4700L)
            Intent(this@SplashScreen, MainActivity::class.java).let{
                startActivity(it)
            }
        }
    }
}