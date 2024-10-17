package com.diegomelgarejo.recetascocina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegomelgarejo.recetascocina.ui.theme.RecetasCocinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecetasCocinaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecetasApp()
                }
            }
        }
    }
}

data class Receta(
    val name: String,
    val tiempo: String,
    val ingredientes: String,
    val calorias: String,
    val imageUrl: String
)

@Composable
fun RecetasApp() {
    var recetaList by remember { mutableStateOf(listOf<Receta>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        RecetaForm { newRecipe ->
            recetaList = recetaList + newRecipe
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(recetaList.size) { index ->
                ItemReceta(receta = recetaList[index]) {
                    recetaList = recetaList.toMutableList().also { it.removeAt(index) }
                }
            }
        }
    }
}

@Composable
fun RecetaForm(onAgregarReceta: (Receta) -> Unit) {
    var name by remember { mutableStateOf("") }
    var tiempo by remember { mutableStateOf("") }
    var ingredientes by remember { mutableStateOf("") }
    var calorias by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre del plato") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(value = tiempo,
            onValueChange = { tiempo = it },
            label = { Text("Tiempo de preparación")},
            modifier = Modifier.fillMaxWidth()
        )
        TextField(value = ingredientes,
            onValueChange = { ingredientes = it },
            label = { Text("Ingredientes") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(value = calorias,
            onValueChange = { calorias = it },
            label = { Text("Calorías por porción") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(value = imageUrl,
            onValueChange = { imageUrl = it },
            label = { Text("Imagen del plato (URL)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val receta = Receta(name, tiempo, ingredientes, calorias, imageUrl)
            onAgregarReceta(receta)
            name = ""
            tiempo = ""
            ingredientes = ""
            calorias = ""
            imageUrl = ""
        }) {
            Text("Agregar receta")
        }
    }
}

@Composable
fun ItemReceta(receta: Receta, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Text(text = receta.name,
                style = MaterialTheme.typography.headlineSmall)
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                val anchoPantalla = maxWidth
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item { InfoReceta(titulo = "Tiempo de preparacion", valor = receta.tiempo, ancho = anchoPantalla)}
                    item { InfoReceta(titulo = "Ingredientes", valor = receta.ingredientes, ancho = anchoPantalla)}
                    item { InfoReceta(titulo = "Calorias por porción", valor = receta.calorias, ancho = anchoPantalla)}
                }
            }

            Button(onClick = onDelete, modifier = Modifier.padding(top = 8.dp)) {
                Text("Borrar")
            }
        }
    }
}

@Composable
fun InfoReceta(titulo: String, valor: String, ancho: androidx.compose.ui.unit.Dp) {
    Column(
        modifier = Modifier
            .width(ancho)
            .fillMaxWidth()
            .padding(end = 32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = titulo, style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = valor, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
    }
}