package com.aaldev.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.aaldev.swoosh.Model.Player
import com.aaldev.swoosh.R
import com.aaldev.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun leagueNextClicked(view: View) {
        if(player.league != ""){
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }

    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        if(mensLeagueBtn.isChecked){
            player.league = "mens"
        } else {
            player.league = ""
        }

    }

    fun onWomensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        if(womensLeagueBtn.isChecked){
            player.league = "womens"
        } else {
            player.league = ""
        }
    }

    fun onCoedClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        if(coedLeagueBtn.isChecked){
            player.league = "coed"
        } else {
            player.league = ""
        }
    }



}
