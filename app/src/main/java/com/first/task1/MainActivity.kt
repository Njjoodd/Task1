package com.first.task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.Style
import com.first.task1.ui.theme.Task1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Game(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Game(modifier: Modifier = Modifier) {
Column(
    modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
    verticalArrangement = Arrangement.SpaceBetween
){
    Text(
            text = "Android is an operating system.",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp),

        )
Row(
    modifier = Modifier.fillMaxWidth(),

) {
    Button(
        onClick = { /* TODO: Handle True */ },
        modifier = Modifier.weight(1f)
    ) {
        Text("True")
    }
                Spacer(modifier = Modifier.width(16.dp))

                Button(
                onClick = { /* TODO: Handle False */ },
        modifier = Modifier.weight(1f)
    ) {
        Text("False")
    }
}
        Result(text = "Correct Answer", modifier = Modifier.align(Alignment.CenterHorizontally))

    Button(
        onClick = {/* TODO: Go to next question*/},
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp)
        ) {
        Text("Next Question")
    }
    }
}

@Composable
fun Result(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(180.dp)
            .background(Color.Green, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 18.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GamePreview() {
    Task1Theme {
        Game()
    }
}
