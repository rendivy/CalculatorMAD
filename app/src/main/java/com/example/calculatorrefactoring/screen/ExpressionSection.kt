package com.example.calculatorrefactoring.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.calculatorrefactoring.R
import com.example.calculatorrefactoring.data.utils.Constants
import com.example.calculatorrefactoring.domain.entity.CalculatorAction
import com.example.calculatorrefactoring.presentation.CalculatorViewModel
import com.example.calculatorrefactoring.ui.theme.GoogleSansBold
import com.example.calculatorrefactoring.ui.theme.LargeFontSize
import com.example.calculatorrefactoring.ui.theme.MediumFontSize


@Composable
fun ExpressionSection(calculatorViewModel: CalculatorViewModel) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val resultState by calculatorViewModel.resultState.collectAsStateWithLifecycle()
    val expressionSectionPadding =
        if (screenHeight >= 780.dp && screenWidth >= 360.dp) 48.dp else 16.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = "Calculator",
            color = Color.White,
            fontSize = MediumFontSize,
            fontFamily = GoogleSansBold
        )
        Spacer(modifier = Modifier.height(expressionSectionPadding))
        Text(
            text = resultState.firstNumber + (resultState.operator?.symbol
                ?: "") + resultState.secondNumber,
            maxLines = 1,
            color = Color.White,
            fontSize = LargeFontSize,
            fontFamily = GoogleSansBold
        )
        Spacer(modifier = Modifier.height(expressionSectionPadding))
        IconButton(
            onClick = { /*TODO*/ },

            modifier = Modifier
                .align(alignment = Alignment.End)
                .size(48.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.delete_text_button),
                contentDescription = "Clear button",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.padding(4.dp))
        ButtonSection(calculatorViewModel = calculatorViewModel)


    }
}
