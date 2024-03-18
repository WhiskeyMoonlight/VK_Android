package com.example.lesson2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val myView = findViewById<TextView>(R.id.second_activity__tv)
        val number = intent.getStringExtra(MainActivity.NUMBER)?.toIntOrNull() ?: 0
        myView.text = number.toString()
        val color = if (number % 2 == 0) R.color.imperial else R.color.cobalt
        myView.setBackgroundResource(color)
    }

}