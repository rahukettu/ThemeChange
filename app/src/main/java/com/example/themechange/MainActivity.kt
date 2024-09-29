package com.example.themechange
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themechange.ui.theme.ThemeChangeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThemeChangeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {  // Fixed missing parentheses
    val appModifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My title",
            style = MaterialTheme.typography.headlineSmall,
            modifier = appModifier
        )

        OutlinedTextField(
            value = "Text here",
            onValueChange = { /* Handle input */ },
            modifier = appModifier
        )

        Button(
            onClick = { /* Handle click */ },
            modifier = appModifier
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    ThemeChangeTheme {
        MyApp()  // Corrected the missing call to MyApp() to show in the preview
    }
}