package com.example.rectanglecalculator.model

data class Rectangle(val length: Double, val width: Double) {
    fun calculateArea(): Double {
        return length * width
    }
}