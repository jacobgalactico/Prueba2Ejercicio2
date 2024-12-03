package com.example.prueba2ejercicio2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prueba2ejercicio2.ui.theme.Prueba2Ejercicio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prueba2Ejercicio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EventList(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val resources = context.resources
    val packageName = context.packageName
    val events = listOf("event1", "event2", "event3")
    Column(modifier = modifier.padding(16.dp)) {
        events.forEach { event ->
            Text(
                text = stringResource(id = resources.getIdentifier(event, "string", packageName)),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable {
                        val intent = Intent(context, EventDetailActivity::class.java).apply {
                            putExtra("event_name", event)
                        }
                        context.startActivity(intent)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventListPreview() {
    Prueba2Ejercicio2Theme {
        EventList()
    }
}