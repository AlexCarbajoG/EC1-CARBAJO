package com.example.evaluacioncontinua1

import android.os.Bundle
import android.provider.CalendarContract.Instances
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NumeroMayorActivity : AppCompatActivity() {

    private lateinit var n1: EditText
    private lateinit var n2: EditText
    private lateinit var n3: EditText
    private lateinit var n4: EditText
    private lateinit var btncalcular: Button
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numero_mayor)

        n1 = findViewById(R.id.n1)
        n2 = findViewById(R.id.n2)
        n3 = findViewById(R.id.n3)
        n4 = findViewById(R.id.n4)
        btncalcular = findViewById(R.id.btncalcular)
        resultado = findViewById(R.id.resultado)

        btncalcular.setOnClickListener {
            val numeros = listOf(
                n1.text.toString().toDoubleOrNull(),
                n2.text.toString().toDoubleOrNull(),
                n3  .text.toString().toDoubleOrNull(),
                n4.text.toString().toDoubleOrNull()
            )

            if (numeros.all { it != null }) {
                val mayor = numeros.filterNotNull().maxOrNull()
                resultado.text = "El número mayor es: $mayor"
            } else {
                Toast.makeText(this, "Ingrese todos los números correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

}