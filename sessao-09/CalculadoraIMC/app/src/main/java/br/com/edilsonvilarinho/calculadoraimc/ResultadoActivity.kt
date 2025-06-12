package br.com.edilsonvilarinho.calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    lateinit var textViewPeso: TextView
    lateinit var textViewAltura: TextView
    lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultado = intent.getSerializableExtra("resultado") as Resultado

        textViewPeso = findViewById(R.id.textViewPeso)
        textViewAltura = findViewById(R.id.textViewAltura)
        textViewResultado = findViewById(R.id.textViewResultado)

        textViewPeso.text = "Peso: ${resultado.peso}"
        textViewAltura.text = "Altura: ${resultado.altura}"

        when{
            resultado.imc < 18.5 -> textViewResultado.text = getString(R.string.abaixo_do_peso)
            resultado.imc in 18.5..24.9 -> textViewResultado.text = getString(R.string.peso_normal)
            resultado.imc in 25.0..29.9 -> textViewResultado.text = getString(R.string.sobrepeso)
            resultado.imc in 30.0..34.9 -> textViewResultado.text =
                getString(R.string.obesidade_grau_1)
            resultado.imc in 35.0..39.9 -> textViewResultado.text =
                getString(R.string.obesidade_grau_2)
            resultado.imc >= 40.0 -> textViewResultado.text = getString(R.string.obesidade_grau_3)
            else -> textViewResultado.text = "Erro"
        }
    }
}