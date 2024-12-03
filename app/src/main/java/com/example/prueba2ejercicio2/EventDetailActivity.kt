package com.example.prueba2ejercicio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class EventDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val eventName = intent.getStringExtra("event_name") ?: "event1"
        setContent {
            Prueba2Ejercicio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventDetail(eventName, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EventDetail(eventName: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val resources = context.resources
    val packageName = context.packageName
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = stringResource(id = resources.getIdentifier(eventName, "string", packageName)))
        Text(text = stringResource(id = R.string.name))
        Text(text = stringResource(id = R.string.description))
        Text(text = stringResource(id = R.string.address))
        Text(text = stringResource(id = R.string.price))
        Text(text = stringResource(id = R.string.date))
        Text(text = stringResource(id = R.string.year))
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailPreview() {
    Prueba2Ejercicio2Theme {
        EventDetail("event1")
    }
}