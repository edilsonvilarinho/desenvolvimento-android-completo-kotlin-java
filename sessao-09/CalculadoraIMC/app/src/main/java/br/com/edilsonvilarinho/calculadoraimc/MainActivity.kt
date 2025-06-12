package br.com.edilsonvilarinho.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    lateinit var textInputLayoutPeso: TextInputLayout
    lateinit var textInputLayoutAltura: TextInputLayout

    lateinit var textInputEditPeso: TextInputEditText
    lateinit var textInputEditAltura: TextInputEditText

    lateinit var buttonCalcularIMC: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textInputLayoutPeso = findViewById(R.id.textInputLayoutPeso)
        textInputLayoutAltura = findViewById(R.id.textInputLayoutAltura)

        textInputEditPeso = findViewById(R.id.textInputEditPeso)
        textInputEditAltura = findViewById(R.id.textInputEditAltura)

        buttonCalcularIMC = findViewById(R.id.buttonCalcularIMC)

        buttonCalcularIMC.setOnClickListener {

            if (textInputEditPeso.text.toString().isEmpty()) {
                textInputLayoutPeso.error = getString(R.string.campo_inv_lido)
            } else if (textInputEditAltura.text.toString().isEmpty()) {
                textInputLayoutAltura.error = getString(R.string.campo_inv_lido)
            } else {
                val peso = textInputEditPeso.text.toString().toDouble()
                val altura = textInputEditAltura.text.toString().toDouble()
                val imc = peso / (altura * altura)
                val intent = Intent(this, ResultadoActivity::class.java)
                val resultado = Resultado(peso, altura, imc, diagnostico = "")
                intent.putExtra("resultado", resultado)
                startActivity(intent)
            }

        }
    }
}