package com.example.secondtask_composecalculator


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val expression = remember { mutableStateOf("")}
            CalculatorView(expression)
        }
    }
}
@Preview (showBackground = true, device = "spec:width=1080px,height=1920px,dpi=440")
@Composable
fun TestPreview(){
    val expression = remember { mutableStateOf("")}
    CalculatorView(expression)
}




