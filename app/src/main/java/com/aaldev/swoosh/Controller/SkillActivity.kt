package com.aaldev.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aaldev.swoosh.Model.Player
import com.aaldev.swoosh.R
import com.aaldev.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun onBeginnerClick(view: View){
        ballerSkillButton.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClick(view: View){
        beginnerSkillButton.isChecked = false
        player.skill = "baller"
    }



    fun onSkillFinishClicked(view: View) {
        if(player.skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }


}
