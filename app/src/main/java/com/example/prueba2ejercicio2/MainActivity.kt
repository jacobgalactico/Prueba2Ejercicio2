package com.example.prueba2ejercicio2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prueba2ejercicio2.ui.theme.Prueba2Ejercicio2Theme

class MainActivity : ComponentActivity() {
    private var events = mutableStateListOf(
        Event("Concierto de Rock", "Un concierto emocionante", "Calle Falsa 123", "20€", "12/12/2024"),
        Event("Taller de Pintura", "Aprende a pintar", "Plaza de la Cultura", "15€", "15/01/2025"),
        Event("Feria de Tecnología", "Explora lo último en tecnología", "Centro de Convenciones", "Gratis", "01/02/2025")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Prueba2Ejercicio2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            val intent = Intent(this@MainActivity, AddEventActivity::class.java)
                            startActivityForResult(intent, REQUEST_CODE_ADD_EVENT)
                        }) {
                            Icon(Icons.Default.Add, contentDescription = "Añadir Evento")
                        }
                    }
                ) { innerPadding ->
                    EventList(
                        events = events,
                        onEventClick = { event ->
                            val intent = Intent(this@MainActivity, EventDetailActivity::class.java).apply {
                                putExtra("event_name", event.name)
                                putExtra("event_description", event.description)
                                putExtra("event_address", event.address)
                                putExtra("event_price", event.price)
                                putExtra("event_date", event.date)
                            }
                            startActivity(intent)
                        },
                        onEventDelete = { event ->
                            events.remove(event)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_EVENT && resultCode == RESULT_OK) {
            val newEvent = data?.getParcelableExtra<Event>("new_event")
            if (newEvent != null) {
                events.add(newEvent)
            }
        }
    }

    companion object {
        const val REQUEST_CODE_ADD_EVENT = 1
    }
}

@Composable
fun EventList(
    events: List<Event>,
    onEventClick: (Event) -> Unit,
    onEventDelete: (Event) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(events) { event ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onEventClick(event) },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = event.name, modifier = Modifier.weight(1f))
                IconButton(onClick = { onEventDelete(event) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar Evento")
                }
            }
            Divider()
        }
    }
}