package com.example.tplogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)
        val rclNames = findViewById<RecyclerView>(R.id.rclNames)

        rclNames.setHasFixedSize(true)

        val nameList = getListOfNames()
        val namesAdapter = NameAdapter(nameList)
        rclNames.adapter = namesAdapter

        rclNames.layoutManager = LinearLayoutManager(this)
    }

    private fun getListOfNames(): MutableList<String> {
        val nameList = mutableListOf<String>()
        nameList.add("ahmed")
        nameList.add("yassine")
        nameList.add("sonia")
        nameList.add("mariem")
        nameList.add("taha")
        nameList.add("oussema")
        nameList.add("fatma")
        nameList.add("haythem")
        nameList.add("ayoub")
        nameList.add("aya")
        nameList.add("chyioux ")
        return nameList
    }
    }
