package com.example.prueba2ejercicio2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.prueba2ejercicio2.ui.theme.Prueba2Ejercicio2Theme

class AddEventActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prueba2Ejercicio2Theme {
                AddEventForm(onSave = { event ->
                    val resultIntent = Intent().apply {
                        putExtra("new_event", event)
                    }
                    setResult(Activity.RESULT_OK, resultIntent)
                    finish()
                })
            }
        }
    }
}

@Composable
fun AddEventForm(onSave: (Event) -> Unit) {
    var name by remember { mutableStateOf(TextFieldValue()) }
    var description by remember { mutableStateOf(TextFieldValue()) }
    var address by remember { mutableStateOf(TextFieldValue()) }
    var price by remember { mutableStateOf(TextFieldValue()) }
    var date by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Nombre") })
        TextField(value = description, onValueChange = { description = it }, label = { Text("Descripción") })
        TextField(value = address, onValueChange = { address = it }, label = { Text("Dirección") })
        TextField(value = price, onValueChange = { price = it }, label = { Text("Precio") })
        TextField(value = date, onValueChange = { date = it }, label = { Text("Fecha") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onSave(Event(name.text, description.text, address.text, price.text, date.text))
        }) {
            Text("Guardar")
        }
    }
}
