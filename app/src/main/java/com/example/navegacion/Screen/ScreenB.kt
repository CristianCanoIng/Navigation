import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacion.data.RegistroRepository
import com.example.navegacion.model.Registro

@Composable
fun ScreenB(
    navController: NavController,
    nombre: String? = null,
    correo: String? = null,
    profesion: String? = null
) {
    if (!nombre.isNullOrBlank() && !correo.isNullOrBlank() && !profesion.isNullOrBlank()) {
        val nuevo = Registro(nombre, correo, profesion)
        if (RegistroRepository.registros.lastOrNull() != nuevo) {
            RegistroRepository.registros.add(nuevo)
        }
    }

    val backgroundGradient = Brush.verticalGradient(
        listOf(Color.Black, Color(0xFF2C2C2C))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registros",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(RegistroRepository.registros) { registro ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Nombre: ${registro.nombre}", color = Color.White)
                        Text("Correo: ${registro.correo}", color = Color.White)
                        Text("Profesión: ${registro.profesion}", color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = { navController.navigate("ScreenA") },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Volver", fontSize = 18.sp)
        }
    }
}

