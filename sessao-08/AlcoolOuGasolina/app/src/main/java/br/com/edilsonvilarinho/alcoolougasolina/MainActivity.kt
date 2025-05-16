package br.com.edilsonvilarinho.alcoolougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    lateinit var textInputLayoutAlcool: TextInputLayout
    lateinit var textInputEditTextAlcool: TextInputEditText
    lateinit var textInputLayoutGasolina: TextInputLayout
    lateinit var textInputEditTextGasolina: TextInputEditText

    lateinit var buttonCalcular: Button
    lateinit var textViewResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textInputLayoutAlcool = findViewById(R.id.textInputLayoutAlcool)
        textInputLayoutGasolina = findViewById(R.id.textInputLayoutGasolina)

        textInputEditTextAlcool = findViewById(R.id.textInputEditTextAlcool)
        textInputEditTextGasolina = findViewById(R.id.textInputEditTextGasolina)

        buttonCalcular = findViewById(R.id.buttonCalcular)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonCalcular.setOnClickListener { calcular() }

    }

    private fun calcular() {
        val precoAlcool = textInputEditTextAlcool.text.toString()
        val precoGasolina = textInputEditTextGasolina.text.toString()
        if (validarCampos(precoAlcool, precoGasolina)) {
            val precoAlcoolDouble = precoAlcool.toDouble()
            val precoGasolinaDouble = precoGasolina.toDouble()
            val resultado = precoAlcoolDouble / precoGasolinaDouble
            if (resultado >= 0.7) {
                textViewResultado.text = "Melhor utilizar gasolina"
            } else {
                textViewResultado.text = "Melhor utilizar álcool"
            }
        }
        textInputEditTextAlcool.text = null
        textInputEditTextGasolina.text = null
        textInputEditTextAlcool.requestFocus()
    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        textInputLayoutAlcool.error = null
        textInputLayoutGasolina.error = null
        if (precoAlcool.isEmpty()) {
            textInputLayoutAlcool.error = "Digite o preço do álcool"
            return false
        } else if (precoGasolina.isEmpty()) {
            textInputLayoutGasolina.error = "Digite o preço da gasolina"
            return false
        }
        return true
    }
}