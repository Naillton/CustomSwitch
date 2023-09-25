package com.nailton.customswitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nailton.customswitch.ui.theme.CustomSwitchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomSwitchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    customSwitch()
                    customList(
                        list = listOf(
                            "One",
                            "Two",
                            "Three",
                            "Four",
                            "Five",
                            "Six",
                            "Seven",
                            "Eight",
                            "Nine",
                            "Ten",
                            "Eleven",
                            "Twelve",
                            "Thrith",
                            "Fourth",
                            "Four",
                            "Five",
                            "Six",
                            "Seven",
                            "Eight",
                            "Nine",
                            "Ten",
                            "Eleven",
                            "Twelve",
                            "Thrith",
                            "Fourth"
                        )
                    )
                }
            }
        }
    }
}

/**
 * Criando composable de lista personalzada com scrool
 */
@Composable
fun customList(list: List<String>) {
    Column(
        Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (i in list) {
            Text(i, Modifier.padding(12.dp))
            Divider(color = Color.Black)
        }
    }
}

/**
 * Composable com implementacao de switch
 */
@Composable
fun customSwitch() {
    var state by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Switch(
            checked = state,
            onCheckedChange = { state = it }
        )

        if (state) {
            Greeting(name = "Switch is true")
        } else {
            Greeting(name = "Switch is false")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomSwitchTheme {
        customSwitch()
        customList(list = listOf("One", "Two", "Three", "Four", "Five", "Six"))
    }
}