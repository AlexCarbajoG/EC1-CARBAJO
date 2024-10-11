package com.example.evaluacioncontinua1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CuadradoActivity : AppCompatActivity() {
    private lateinit var tvResultados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuadrado)

        tvResultados = findViewById(R.id.tvResultados)

        val resultados = StringBuilder()
        for (numero in 15..70) {
            val cuadrado = numero * numero
            val mitad = numero / 2.0
            resultados.append("Número: $numero - Cuadrado: $cuadrado - Mitad: ${"%.2f".format(mitad)}\n")
        }
        tvResultados.text = resultados.toString()
    }
}