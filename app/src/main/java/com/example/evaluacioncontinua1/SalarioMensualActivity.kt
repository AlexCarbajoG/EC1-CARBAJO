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

class SalarioMensualActivity : AppCompatActivity() {

    private lateinit var etSalario: EditText
    private lateinit var etAnios: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salario_mensual)

        etSalario = findViewById(R.id.etSalario)
        etAnios = findViewById(R.id.etAnios)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val salario = etSalario.text.toString().toDoubleOrNull()
            val anios = etAnios.text.toString().toDoubleOrNull()

            if (salario != null && anios != null) {
                val porcentajeUtilidad = when {
                    anios < 1 -> 0.05
                    anios < 2 -> 0.07
                    anios < 5 -> 0.10
                    anios < 10 -> 0.15
                    else -> 0.20
                }
                val utilidad = salario * porcentajeUtilidad
                tvResultado.text = "La utilidad es: S/ ${"%.2f".format(utilidad)}"
            } else {
                Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}