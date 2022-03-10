package com.gamenowstationx.arabetgamenow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GameStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)
    }


    fun goStart(view: View) {
        Intent(applicationContext, Gameplay::class.java).also { startActivity(it) }
        finish()
    }
}