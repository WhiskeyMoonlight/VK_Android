package com.example.lesson2

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var intList: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intList = savedInstanceState
            ?.getIntegerArrayList(KEY)?.toMutableList() ?: mutableListOf()
        val recyclerview: RecyclerView = findViewById(R.id.activity_main__rv_cells)
        val adapter = CellAdapter(intList) // заполняет список данными
        recyclerview.adapter = adapter
        val orientation = resources.configuration.orientation
        val columns = if (orientation == Configuration.ORIENTATION_PORTRAIT)
            PORTRAIT_ORIENTATION_COUNT else LANDSCAPE_ORIENTATION_COUNT
        recyclerview.layoutManager = GridLayoutManager(this, columns)

        val fab: FloatingActionButton = findViewById(R.id.activity_main__fab)
        fab.setOnClickListener {
            intList.add(intList.size)
            adapter.notifyItemChanged(intList.size - 1)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList(KEY, ArrayList<Int>(intList))
    }

    companion object {
        const val KEY = "List"
        const val NUMBER = "Number"
        const val PORTRAIT_ORIENTATION_COUNT = 3
        const val LANDSCAPE_ORIENTATION_COUNT = 4
    }

}
