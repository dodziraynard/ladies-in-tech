package com.hrd.myapp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertButton = findViewById<Button>(R.id.convert_button)
        val amountInput = findViewById<EditText>(R.id.amount_input)
        val displayValue = findViewById<TextView>(R.id.display_value)

        convertButton.setOnClickListener {
            val amount = amountInput.text.toString().toFloat()
            val valueInCedis = amount * 12.00
            displayValue.text = valueInCedis.toString()
        }
    }
}