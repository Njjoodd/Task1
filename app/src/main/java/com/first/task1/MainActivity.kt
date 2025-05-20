package com.first.task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
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
fun Game(modifier: Modifier = Modifier)
{
   val questions = listOf(
       "Android is an operating system." to true,
       "Kotlin is developed by Microsoft" to false,
       "XML is used for UI in Android" to true)

    var questionIndex by remember { mutableStateOf(0) }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }
    val (question, correctAnswer) = questions[questionIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = question,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { isCorrect = true },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(R.string.text_true))
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { isCorrect = false },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(R.string.text_false))
            }
        }

        if (isCorrect != null) {
            Result(
                isCorrect = isCorrect!!,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Button(
            onClick = {
                questionIndex = (questionIndex + 1) % questions.size
                isCorrect = null
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp)
        ) {
            Text(stringResource(R.string.next_question))
        }
    }
}

@Composable
fun Result(isCorrect: Boolean, modifier: Modifier = Modifier) {
    val text = stringResource(if (isCorrect) R.string.correct_answer else R.string.wrong_answer)
    val imageRes = if (isCorrect) R.drawable.correct_answer else R.drawable.wrong_answer
    val bgColor = if (isCorrect) Color.Green else Color.Red

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .size(180.dp)
                .background(bgColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    Task1Theme {
        Game()
    }
}
