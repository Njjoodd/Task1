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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Android is an operating system.",
            fontSize = 30.sp,
            color = Color.Black,
        )

        Result(text = "Correct Answer", modifier = Modifier.align(Alignment.Center))


        NextQuestionButton(
            onClick = { /* TODO: go to next question */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
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

@Composable
fun NextQuestionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text("Next Question")
    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    Task1Theme {
        Game()
    }
}
