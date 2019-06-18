package com.aaldev.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aaldev.swoosh.Utilities.EXTRA_LEAGUE
import com.aaldev.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    var selectedLeague = ""
//    val TAG = "leagueSelector"
//
//    val myLeagues = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked(view: View) {
        if(selectedLeague != ""){
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }

    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        if(mensLeagueBtn.isChecked){
            selectedLeague = "mens"
        } else {
            selectedLeague = ""
        }

    }

    fun onWomensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        if(womensLeagueBtn.isChecked){
            selectedLeague = "womens"
        } else {
            selectedLeague = ""
        }
    }

    fun onCoedClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        if(coedLeagueBtn.isChecked){
            selectedLeague = "coed"
        } else {
            selectedLeague = ""
        }
    }

//    fun fileAndLog(ltype: String) {
//        if(myLeagues.contains(ltype)){
//            myLeagues.remove(ltype)
//        } else {
//            myLeagues.add(ltype)
//        }
//        Log.d(TAG, selectedLeague)
//        Log.d(TAG, "array:" + myLeagues)
//    }




}
