package com.example.jetpacktest.ui.start

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.jetpacktest.R

class StartActivity : AppCompatActivity() {

    lateinit var viewModel  : StartViewModel
    lateinit var appleNumber: TextView
    lateinit var btnAddApple: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, StartFragment.newInstance())
                .commitNow()
        }

        //Link's the viewModel with the Activity
        viewModel   = ViewModelProviders.of(this).get(StartViewModel::class.java)
        appleNumber = findViewById(R.id.appleCount)
        btnAddApple = findViewById(R.id.btnAddApple)


        btnAddApple.setOnClickListener { addApple() }
    }

    //Get's the apple count of the viewModel and set on the TextView
    private fun showApple(){
        var appleCount = viewModel.apple.toString()
        appleNumber.text     = appleCount
    }

    //Button Listener to update the apple count
    private fun addApple(){
        viewModel.increaseAppleCounter()
        showApple()
    }

    //Override's onResume to update the appleCount
    override fun onResume() {
        super.onResume()
        showApple()
    }

}
