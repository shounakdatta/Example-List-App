package com.example.shounakpc.listapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var myListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = resources
        myListView = findViewById<ListView>(R.id.myListView)
        val items = res.getStringArray(R.array.items)
        val descriptions = res.getStringArray(R.array.descriptions)
        val prices = res.getStringArray(R.array.prices)

        val adapter = ItemAdapter(this, items, descriptions, prices)
        myListView.adapter = adapter;
        
        myListView.setOnItemClickListener { parent, view, position, id ->
            val showDetailActivity = Intent(this, DetailActivity::class.java)
            showDetailActivity.putExtra("itemIndex", position)
            startActivity(showDetailActivity)
        }

    }
}
