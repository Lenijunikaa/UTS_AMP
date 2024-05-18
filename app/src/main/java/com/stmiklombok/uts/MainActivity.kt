package com.example.rectanglecalculator.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rectanglecalculator.R
import com.example.rectanglecalculator.viewmodel.RectangleViewModel
import com.stmiklombok.uts.R

class MainActivity : AppCompatActivity() {

    private val viewModel: RectangleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextLength = findViewById<EditText>(R.id.editTextLength)
        val editTextWidth = findViewById<EditText>(R.id.editTextWidth)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val length = editTextLength.text.toString().toDoubleOrNull() ?: 0.0
            val width = editTextWidth.text.toString().toDoubleOrNull() ?: 0.0
            viewModel.calculateArea(length, width)
        }

        viewModel.area.observe(this, Observer { area ->
            textViewResult.text = "Hasil: $area"
        })
    }
}