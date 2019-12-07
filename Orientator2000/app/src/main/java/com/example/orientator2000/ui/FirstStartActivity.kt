package com.example.orientator2000.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.orientator2000.MainActivity
import com.example.orientator2000.R

import kotlinx.android.synthetic.main.activity_first_start.*

class FirstStartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_start)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show()
            sendMessage(view)
        }
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
