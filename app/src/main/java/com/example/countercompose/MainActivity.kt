package com.example.countercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.countercompose.ui.theme.CounterComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterComposeTheme {

                CommonAncestor()

            }
        }
    }
}

@Composable
fun CommonAncestor() {
    var count by rememberSaveable { mutableStateOf(0) }
    var lastAction by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            CounterA(count = if (lastAction == "increment") count else null) {
                count++
                lastAction = "increment"
            }
            Spacer(modifier = Modifier.width(20.dp))
            CounterB(count = if (lastAction == "decrement") count else null) {
                count--
                lastAction = "decrement"
            }
        }
    }
}

@Composable
fun CounterA(count: Int?, onIncrement: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Counter A : ${count ?: ""}")
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = onIncrement) {
            Text(text = "Increment")
        }
    }
}

@Composable
fun CounterB(count: Int?, onDecrement: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Counter B : ${count ?: ""}")
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = onDecrement) {
            Text(text = "Decrement")
        }
    }
}
