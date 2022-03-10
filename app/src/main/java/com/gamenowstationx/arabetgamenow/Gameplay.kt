package com.gamenowstationx.arabetgamenow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_gameplay.*

class Gameplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)


        var sakuras = arrayListOf(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9)

        for (sakura in sakuras) {
            if (sakura.tag == "mermaid"){
                sakura.setImageResource(R.drawable.mermaid)
            }
            else {
                sakura.setImageResource(R.drawable.fish)
            }
            sakura.isClickable = false
        }
        Handler().postDelayed({
            for (sakura in sakuras){
                sakura.setImageResource(R.drawable.coral)
                sakura.isClickable = true
            }
            rulesTxt.isVisible = false
        }, 1000)

        var a = 0
        for (n in sakuras){
            n.setOnClickListener {
                if (n.tag == "mermaid"){
                    a++
                    n.setImageResource(R.drawable.mermaid)
                }
                else {
                    n.setImageResource(R.drawable.fish)
                    for (sakura in sakuras){
                        sakura.isClickable = false
                    }
                    restrtBtn.isVisible = true
                    restrtBtn.text = "Try Again!"
                }
                n.isClickable = false

                if (a == 3){
                    restrtBtn.text = "You won!\nStart over?"
                    restrtBtn.isVisible = true
                    for (sakura in sakuras){
                        sakura.isClickable = false
                    }
                }

            }

        }
    }

    fun restartGame(view: View) {
        Intent(applicationContext, Gameplay::class.java).also { startActivity(it) }
        finish()
    }

}