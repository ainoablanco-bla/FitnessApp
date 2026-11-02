package org.insbaixcamp.paginaperfil.ui.screen

import androidx.compose.foundation.Image
import org.insbaixcamp.paginaperfil.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alçada: Int,
    pes: Double,
    pesObjectiu: Double,
    objectiu: String,
    nivellActivitat: String,
    guardar: () -> Unit,
    onSave: (String, String, String, String, Double, Double, Int) -> Unit
) {
    var nomNou: String by remember { mutableStateOf(nom) }
    var emailNou: String by remember { mutableStateOf(email) }
    var dataNaixementNou: String by remember { mutableStateOf(dataNaixement) }
    var genereNou: String by remember { mutableStateOf(genere) }
    var alçadaNou: Int by remember { mutableStateOf(alçada) }
    var pesNou: Double by remember { mutableStateOf(pes) }
    var pesObjectiuNou: Double by remember { mutableStateOf(pesObjectiu) }
    var objectiuNou: String by remember { mutableStateOf(objectiu) }
    var nivellActivitatNou: String by remember { mutableStateOf(nivellActivitat) }

    Column(){
        Row(){
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Black),)
            Column(){
                Button(onClick = {}){Text(text = "Canviar foto") }
                Button(onClick = {}) {Text(text = "Eliminar foto") }
            }
        }
        Text("Dades personals", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )
        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            )

        OutlinedTextField(
            value = dataNaixementNou,
            onValueChange = { dataNaixementNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )

        //Genere
        OutlinedTextField(
            value = genereNou,
            onValueChange = { genereNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )

        //Dades físiques
        Text("Dades físiques")
        Row(Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = alçadaNou.toString(),
                onValueChange = { alçadaNou = it.toInt() },
                label = { Text("Alçada") },
            )
            OutlinedTextField(
                value = pesNou.toString(),
                onValueChange = { pesNou = it.toDouble() },
                label = { Text("Pes") },
            )
            OutlinedTextField(
                value = pesObjectiuNou.toString(),
                onValueChange = { pesObjectiuNou = it.toDouble() },
                label = { Text("Pes objectiu") },
            )
        }
        Button(
            onClick = {
                onSave(
                    nomNou,
                    emailNou,
                    dataNaixementNou,
                    genereNou,
                    pesNou,
                    pesObjectiuNou,
                    alçadaNou
                )
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        {
            Text("Guardar canvis")
        }

    }
}