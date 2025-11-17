package com.ztr.masala

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = listOf(
            "Laal Mirch (Red Chilli) - 1kg",
            "Haldi (Turmeric) - 1kg",
            "Jeera (Cumin) - 1kg",
            "Garam Masala - 500g",
            "Dhaniya Powder - 1kg",
            "Hing - 100g",
            "Black Pepper - 250g",
            "Turmeric Powder Premium - 1kg"
        )

        val listView = findViewById<ListView>(R.id.listProducts)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, products)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val product = products[position]
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("product_name", product)
            startActivity(intent)
        }
    }
}
