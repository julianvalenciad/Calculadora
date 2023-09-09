package com.julianvalencia.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    fun actualizarTexto(textView: TextView, num: String, boton: Button) {
        boton.setOnClickListener {
            // Aquí establece el valor que deseas en el TextView cuando se presione el botón
            val textoActual = textView.text.toString()
            val valorAConcatenar = num // Reemplaza esto con el valor que deseas concatenar
            val nuevoTexto = "$textoActual$valorAConcatenar"

            // Establece el nuevo texto en el TextView
            textView.text = nuevoTexto
        }
    }

    fun calcularOperacion(operacion: String): Double {
        // Divide la cadena en dos partes en función del operador (+, -, *, /)
        val partes = operacion.split("[+\\-*/]".toRegex())

        if (partes.size != 2) {
            // La cadena no contiene exactamente dos números y un operador
            return Double.NaN
        }

        val numero1 = partes[0].trim().toDoubleOrNull()
        val numero2 = partes[1].trim().toDoubleOrNull()

        if (numero1 == null || numero2 == null) {
            // No se pudieron convertir ambas partes en números válidos
            return Double.NaN
        }

        // Encuentra el operador en la cadena original
        val operador = operacion.find { it in "+-*/" } ?: return Double.NaN

        // Realiza la operación matemática
        return when (operador) {
            '+' -> numero1 + numero2
            '-' -> numero1 - numero2
            '*' -> numero1 * numero2
            '/' -> {
                if (numero2 != 0.0) {
                    numero1 / numero2
                } else {
                    Double.NaN // División por cero
                }
            }
            else -> Double.NaN
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Asigna el TextView de la interfaz a la variable textView
        textView = findViewById(R.id.editext_oper)
        val button_1 = findViewById<Button>(R.id.number_1)
        actualizarTexto(textView,"1",button_1)
        val button_2 = findViewById<Button>(R.id.number_2)
        actualizarTexto(textView,"2",button_2)
        val button_3 = findViewById<Button>(R.id.number_3)
        actualizarTexto(textView,"3",button_3)
        val button_4 = findViewById<Button>(R.id.number_4)
        actualizarTexto(textView,"4",button_4)
        val button_5 = findViewById<Button>(R.id.number_5)
        actualizarTexto(textView,"5",button_5)
        val button_6 = findViewById<Button>(R.id.number_6)
        actualizarTexto(textView,"6",button_6)
        val button_7 = findViewById<Button>(R.id.number_7)
        actualizarTexto(textView,"7",button_7)
        val button_8 = findViewById<Button>(R.id.number_8)
        actualizarTexto(textView,"8",button_8)
        val button_9 = findViewById<Button>(R.id.number_9)
        actualizarTexto(textView,"9",button_9)


        val suma = findViewById<Button>(R.id.suma)
        actualizarTexto(textView,"+",suma)
        val resta = findViewById<Button>(R.id.resta)
        actualizarTexto(textView,"-", resta)
        val multi = findViewById<Button>(R.id.Multiplicar)
        actualizarTexto(textView,"*", multi)
        val division = findViewById<Button>(R.id.Dividir)
        actualizarTexto(textView,"/", division)

        val igual = findViewById<Button>(R.id.Igual)
        igual.setOnClickListener {
            val textoActual = textView.text.toString()
            textView.text = (calcularOperacion(textoActual)).toString()
        }
    }
}