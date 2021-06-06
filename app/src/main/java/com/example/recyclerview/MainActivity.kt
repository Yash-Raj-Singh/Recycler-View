package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            todo("Hey Yash", false),
             todo("Hey Good", true),
            todo("Hey Morning", false),
            todo("Hey C yaa", true),
        )

        val adapter = todoAdapter(todoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btn.setOnClickListener{
            val title = editText.text.toString()
            val todo = todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size -1)
        }

    }
}