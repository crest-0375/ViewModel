package com.practice.viewmodel.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    var message = "default text"

    fun sendMessage(text: String) {
        message = text
    }
    init{
        Log.d("TAG","initialized")
    }
}