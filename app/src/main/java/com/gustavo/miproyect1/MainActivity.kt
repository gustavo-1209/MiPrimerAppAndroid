package com.gustavo.miproyect1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
                    UserProfileScreen()
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
            .fillMaxSize()
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