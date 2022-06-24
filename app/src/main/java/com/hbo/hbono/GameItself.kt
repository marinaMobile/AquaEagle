package com.hbo.hbono

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_game_itself.*
import kotlinx.android.synthetic.main.dialog.*

class GameItself : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_itself)
        var counter = 0

        CustDialog().show(supportFragmentManager, "MyCustomDialog")
        fish_iv.setOnClickListener{
            counter++
            if (counter==10) {
                DialogRestart().show(supportFragmentManager, "MyNewDialog")

            }
        }

    }


}