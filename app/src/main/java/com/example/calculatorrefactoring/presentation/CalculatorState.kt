package com.example.calculatorrefactoring.presentation

import com.example.calculatorrefactoring.data.Calculator
import com.example.calculatorrefactoring.data.utils.SymbolEnum


data class CalculatorState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val operator: SymbolEnum? = null,
)