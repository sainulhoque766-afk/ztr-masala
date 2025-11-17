package com.ztr.masala

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class OrderListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)

        val listView = findViewById<ListView>(R.id.listOrders)
        val prefs = getSharedPreferences("ztr_orders", Context.MODE_PRIVATE)
        val all = prefs.all
        val orders = ArrayList<String>()
        for ((k,v) in all) {
            orders.add(v as String)
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, orders)
        listView.adapter = adapter
    }
}
