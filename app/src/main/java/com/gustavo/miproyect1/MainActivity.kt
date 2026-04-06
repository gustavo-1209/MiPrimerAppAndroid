package com.gustavo.miproyect1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val avatarUrl: String? = null
val userBio: String? = null
val followerCount: Int? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        UserProfileScreen()

                        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 2.dp)

                        CalculadoraDeSaludScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun UserProfileScreen() {
    val bioDisplay = userBio ?: "Biografía no disponible"

    val statusColor = when {
        followerCount == null -> Color.Gray
        followerCount > 1000 -> Color(0xFFFFD700)
        followerCount > 100 -> Color.Blue
        else -> Color.DarkGray
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = if (avatarUrl == null) Color.LightGray else Color.Green
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = bioDisplay,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Seguidores: ${followerCount ?: 0}",
            color = statusColor,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun CalculadoraDeSaludScreen() {
    var pesoInput by remember { mutableStateOf("") }
    var alturaInput by remember { mutableStateOf("") }

    val pesoValidado = pesoInput.toDoubleOrNull() ?: 0.0
    val alturaValidada = alturaInput.toDoubleOrNull() ?: 0.0

    val resultadoClasificacion = clasificarIMC(pesoValidado, alturaValidada)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Calculadora de IMC",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = pesoInput,
            onValueChange = { pesoInput = it },
            label = { Text("Ingresa tu peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = alturaInput,
            onValueChange = { alturaInput = it },
            label = { Text("Ingresa tu altura (m)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Categoría: $resultadoClasificacion",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}