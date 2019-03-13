package com.example.jetpacktest.ui.start

import android.arch.lifecycle.ViewModel

class StartViewModel : ViewModel() {

    var apple:Int = 0

    fun increaseAppleCounter() {
        ++apple
    }
}
