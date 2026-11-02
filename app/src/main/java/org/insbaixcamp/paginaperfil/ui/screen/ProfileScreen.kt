package org.insbaixcamp.paginaperfil.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import org.insbaixcamp.paginaperfil.R

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alçada: Int,
    pes: Double,
    objectiu: String,
    nivellActivitat: String,
    editar: () -> Unit,
    ) {
    Column() {
        // Caixa de foto, nom i correu electrònic
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .clip(androidx.compose.foundation.shape.CircleShape)
            )
            Text(
                text = nom,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = email,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        // Caixa Informació personal
        Card(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {

                Column() {
                    Text(
                        text = "Edat",
                        color = Color.Gray
                    )
                    val edat = calcularEdat(dataNaixement)
                    Text(
                        text = "$edat",
                        fontWeight = FontWeight.Bold
                    )
                }
                Column() {
                    Text(
                        text = "Genere",
                        color = Color.Gray
                    )
                    Text(
                        text = genere,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column() {
                    Text(
                        "Alçada",
                        color = Color.Gray
                    )
                    Text(
                        text = "$alçada cm",
                        fontWeight = FontWeight.Bold
                    )
                }
                Column() {
                    Text(
                        "Pes",
                        color = Color.Gray
                    )
                    Text(
                        text = "$pes kg",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Caixa d'objectius

        Text(
            "Objectius", fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Card(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        )
        {
            Text(objectiu, Modifier.padding(8.dp))
        }

        // Caixa de nivell d'activitat
        Text(
            "Nivell d'activitat",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Card(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(nivellActivitat, Modifier.padding(8.dp))
        }

    }
}
    fun calcularEdat(dataNaixement: String): Int {
        return try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val dataNaix = sdf.parse(dataNaixement) ?: return 0

            val naixement = Calendar.getInstance().apply { time = dataNaix }
            val avui = Calendar.getInstance()

            var edat = avui.get(Calendar.YEAR) - naixement.get(Calendar.YEAR)

            if (avui.get(Calendar.MONTH) < naixement.get(Calendar.MONTH) ||
                (avui.get(Calendar.MONTH) == naixement.get(Calendar.MONTH) &&
                        avui.get(Calendar.DAY_OF_MONTH) < naixement.get(Calendar.DAY_OF_MONTH))
            ) {
                edat--
            }

            edat
        } catch (_: Exception) {
            0
        }
    }


