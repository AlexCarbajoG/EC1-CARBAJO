package com.example.evaluacioncontinua1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MatriculaActivity : AppCompatActivity() {

    private lateinit var etMaterias: EditText
    private lateinit var btnCalcularCosto: Button
    private lateinit var tvCostoTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricula)

        etMaterias = findViewById(R.id.etMaterias)
        btnCalcularCosto = findViewById(R.id.btnCalcularCosto)
        tvCostoTotal = findViewById(R.id.tvCostoTotal)

        btnCalcularCosto.setOnClickListener {
            val materias = etMaterias.text.toString().toIntOrNull()

            if (materias != null && materias > 0) {
                val costoPorMateria = 520.0
                var costoTotal = costoPorMateria * materias

                if (materias > 5) {
                    costoTotal *= 0.9 // Aplicar 10% de descuento
                }
                tvCostoTotal.text = "El costo total es: S/ ${"%.2f".format(costoTotal)}"
            } else {
                Toast.makeText(this, "Ingrese un número válido de materias", Toast.LENGTH_SHORT).show()
            }
        }
    }
}