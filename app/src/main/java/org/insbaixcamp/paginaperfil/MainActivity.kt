package org.insbaixcamp.paginaperfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.paginaperfil.ui.screen.EditProfileScreen
import org.insbaixcamp.paginaperfil.ui.screen.ProfileScreen
import org.insbaixcamp.paginaperfil.ui.theme.PaginaPerfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaginaPerfilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FitnessApp()
                }
            }
        }
    }
}

@Composable
fun FitnessApp(){
    var nom: String by remember { mutableStateOf("Ainoa Blanco") }
    var email: String by remember { mutableStateOf("ainoablanco14@gmail.com") }
    var dataNaixement: String by remember { mutableStateOf("14/12/2007") }
    var genere: String by remember { mutableStateOf("Dona") }
    var alçada: Int by remember { mutableStateOf(167) }
    var pes: Double by remember { mutableStateOf(55.0) }
    var pesObjectiu: Double by remember { mutableStateOf(0.0) }
    var objectiu: String by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat: String by remember { mutableStateOf("Moderat") }
    var editant: Boolean by remember { mutableStateOf(false) }


    if (editant){
        EditProfileScreen(
            nom, email, dataNaixement, genere, alçada,
            pes, pesObjectiu, objectiu, nivellActivitat, { editant = false })
    }else{
        ProfileScreen(
            nom,
            email,
            dataNaixement,
            genere,
            alçada,
            pes,
            objectiu,
            nivellActivitat,
        { editant = true }
        )

        /**
         * fun editar(){editant=true}
         * {editant=true}
         */
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PaginaPerfilTheme {
       FitnessApp()
    }
}