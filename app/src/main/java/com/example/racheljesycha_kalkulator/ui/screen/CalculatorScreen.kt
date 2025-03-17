package com.example.racheljesycha_kalkulator.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.racheljesycha_kalkulator.viewmodel.CalculatorViewModel

@Composable
@Preview
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Latar belakang hitam
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        // Tampilan hasil input
        Text(
            text = viewModel.input.value,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            textAlign = TextAlign.End
        )

        val buttons = listOf(
            listOf("C", "÷", "×"),
            listOf("7", "8", "9"),
            listOf("4", "5", "6"),
            listOf("1", "2", "3"),
            listOf("0", ".", "%")
        )

        val operators = listOf("⌫", "-", "+")

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .weight(3f),
                verticalArrangement = Arrangement.Top
            ) {
                buttons.forEach { row ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.Start,

                        ) {
                        row.forEach { label ->
                            Spacer(modifier = Modifier.width(8.dp)) // Jarak antar tombol
                            CalculatorButton(label, viewModel)
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .offset(x = 3.dp, y = -4.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                operators.forEach { label ->
                    Spacer(modifier = Modifier.height(8.dp)) // Jarak antar tombol
                    CalculatorButton(label, viewModel)
                }
                Spacer(modifier = Modifier.height(8.dp))
                CalculatorButton("=", viewModel, isLarge = true) // Tombol "=" diperbesar
            }
        }
    }
}

@Composable
fun CalculatorButton(label: String, viewModel: CalculatorViewModel, isLarge: Boolean = false) {
    val buttonColor = when (label) {
        "C" -> Color(0xFFE53935) // Tombol C merah
        "=" -> Color(0xFF1E88E5) // Tombol = biru
        else -> Color(0xFF424242) // Warna tombol lainnya abu gelap
    }

    val buttonModifier = if (isLarge) {
        Modifier.size(80.dp, 170.dp) // Tombol "=" lebih besar ke bawah
    } else {
        Modifier.size(80.dp)
    }

    Button(
        onClick = { viewModel.onButtonClick(label) },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        modifier = buttonModifier
    ) {
        Text(
            text = label,
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}