package com.example.rectanglecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rectanglecalculator.model.Rectangle

class RectangleViewModel : ViewModel() {
    private val _area = MutableLiveData<Double>()
    val area: LiveData<Double> get() = _area

    fun calculateArea(length: Double, width: Double) {
        val rectangle = Rectangle(length, width)
        _area.value = rectangle.calculateArea()
    }
}