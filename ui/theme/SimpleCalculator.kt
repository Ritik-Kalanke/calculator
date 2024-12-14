package com.example.calculator.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleCalculator() {
    var input by remember { mutableStateOf("0") }
    var num1 by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Display area
        TextField(
            value = input,
            onValueChange = { input = it },
            readOnly = true, // read-only, changes happen from button presses
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 24.sp)
        )

        // Buttons for calculator
        Row {
            CalculatorButton("7") { input += "7" }
            CalculatorButton("8") { input += "8" }
            CalculatorButton("9") { input += "9" }
            CalculatorButton("/") {
                num1 = input
                operator = "/"
                input = ""
            }
        }
        Row {
            CalculatorButton("4") { input += "4" }
            CalculatorButton("5") { input += "5" }
            CalculatorButton("6") { input += "6" }
            CalculatorButton("*") {
                num1 = input
                operator = "*"
                input = ""
            }
        }
        Row {
            CalculatorButton("1") { input += "1" }
            CalculatorButton("2") { input += "2" }
            CalculatorButton("3") { input += "3" }
            CalculatorButton("-") {
                num1 = input
                operator = "-"
                input = ""
            }
        }
        Row {
            CalculatorButton("0") { input += "0" }
            CalculatorButton(".") { input += "." }
            CalculatorButton("=") {
                input = calculateResult(num1, input, operator)
            }
            CalculatorButton("+") {
                num1 = input
                operator = "+"
                input = ""
            }
        }
        Row {
            CalculatorButton("C") { input = ""}
            CalculatorButton("<") { input = input.dropLast(1)}
        }
    }
}

@Composable
fun CalculatorButton(label: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.size(80.dp, 80.dp)) {
        Text(text = label, fontSize = 24.sp)
    }
}

// Function to handle basic arithmetic calculations
fun calculateResult(num1: String, num2: String, operator: String): String {
    val n1 = num1.toDoubleOrNull()
    val n2 = num2.toDoubleOrNull()
    if (n1 == null || n2 == null) return "Error"

    return when (operator) {
        "+" -> (n1 + n2).toString()
        "-" -> (n1 - n2).toString()
        "*" -> (n1 * n2).toString()
        "/" -> if (n2 != 0.0) (n1 / n2).toString() else "Error"
        else -> "Error"
    }
}
@Preview(showBackground = true)
@Composable
fun SimpleCalculatorPreview() {
    CalculatorAppTheme {
        SimpleCalculator()  // Display your calculator in preview
    }
}