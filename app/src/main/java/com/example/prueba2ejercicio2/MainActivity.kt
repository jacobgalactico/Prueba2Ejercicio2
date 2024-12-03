package com.example.prueba2ejercicio2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prueba2ejercicio2.ui.theme.Prueba2Ejercicio2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sampleEvents = listOf(
            Event("Concierto de Rock", "Un concierto emocionante", "Calle Falsa 123", "20€", "12/12/2024"),
            Event("Taller de Pintura", "Aprende a pintar", "Plaza de la Cultura", "15€", "15/01/2025"),
            Event("Feria de Tecnología", "Explora lo último en tecnología", "Centro de Convenciones", "Gratis", "01/02/2025")
        )

        setContent {
            Prueba2Ejercicio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventList(
                        events = sampleEvents,
                        onEventClick = { event ->
                            val intent = Intent(this, EventDetailActivity::class.java).apply {
                                putExtra("event_name", event.name)
                                putExtra("event_description", event.description)
                                putExtra("event_address", event.address)
                                putExtra("event_price", event.price)
                                putExtra("event_date", event.date)
                            }
                            startActivity(intent)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EventList(events: List<Event>, onEventClick: (Event) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(events) { event ->
            Text(
                text = event.name,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable { onEventClick(event) }
            )
            Divider()
        }
    }
}
