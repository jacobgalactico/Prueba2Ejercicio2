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
import androidx.compose.ui.unit.dp
import com.example.prueba2ejercicio2.ui.theme.Prueba2Ejercicio2Theme

class EventDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val eventName = intent.getStringExtra("event_name") ?: "Nombre no disponible"
        val eventDescription = intent.getStringExtra("event_description") ?: "Descripción no disponible"
        val eventAddress = intent.getStringExtra("event_address") ?: "Dirección no disponible"
        val eventPrice = intent.getStringExtra("event_price") ?: "Precio no disponible"
        val eventDate = intent.getStringExtra("event_date") ?: "Fecha no disponible"

        val event = Event(
            name = eventName,
            description = eventDescription,
            address = eventAddress,
            price = eventPrice,
            date = eventDate
        )

        setContent {
            Prueba2Ejercicio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventDetail(
                        event = event,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EventDetail(event: Event, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Nombre: ${event.name}")
        Text(text = "Descripción: ${event.description}")
        Text(text = "Dirección: ${event.address}")
        Text(text = "Precio: ${event.price}")
        Text(text = "Fecha: ${event.date}")
    }
}