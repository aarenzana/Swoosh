package com.aaldev.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaldev.swoosh.Model.Player
import com.aaldev.swoosh.R
import com.aaldev.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeaguesText.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
