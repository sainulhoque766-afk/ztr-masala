package com.ztr.masala

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val tvProduct = findViewById<TextView>(R.id.tvProduct)
        val etName = findViewById<EditText>(R.id.etName)
        val etQty = findViewById<EditText>(R.id.etQty)
        val btnPlace = findViewById<Button>(R.id.btnPlaceOrder)

        val product = intent.getStringExtra("product_name") ?: "Unknown Product"
        tvProduct.text = product

        btnPlace.setOnClickListener {
            val name = etName.text.toString().trim()
            val qty = etQty.text.toString().trim()
            if (name.isEmpty() || qty.isEmpty()) {
                Toast.makeText(this, "Please enter name and quantity", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val prefs = getSharedPreferences("ztr_orders", Context.MODE_PRIVATE)
            val orderId = System.currentTimeMillis().toString()
            val orderJson = "${'$'}product|${'$'}name|${'$'}qty"
            prefs.edit().putString(orderId, orderJson).apply()

            Toast.makeText(this, "Order placed (demo). Order ID: ${'$'}orderId", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
