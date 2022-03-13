package br.com.laminar.checkpointum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Checkpoint #01")

        val etValor1 = findViewById<EditText>(R.id.et_valor1)
        val etValor2 = findViewById<EditText>(R.id.et_valor2)
        val rbSoma = findViewById<RadioButton>(R.id.rb_soma)
        val rbSubtrai = findViewById<RadioButton>(R.id.rb_subtrai)
        val rbDivide = findViewById<RadioButton>(R.id.rb_divide)
        val rbMultiplica= findViewById<RadioButton>(R.id.rb_multiplica)

        val btCalcular = findViewById<Button>(R.id.bt_calcular)
        btCalcular.setOnClickListener{
            operacao(rbSoma,rbSubtrai,rbDivide,rbMultiplica,etValor1,etValor2)
        }
    }

    fun operacao(
        rbSoma: RadioButton,
        rbSubtrai: RadioButton,
        rbDivide: RadioButton,
        rbMultiplica: RadioButton,
        etValor1: EditText,
        etValor2: EditText) {

        val n1: Double = etValor1.text.toString().toDouble()
        val n2: Double = etValor2.text.toString().toDouble()
        var r: Double = 0.0

        if (rbSoma.isChecked)  r =  n1 + n2
        else if (rbSubtrai.isChecked) r = n1 - n2
        else if (rbDivide.isChecked) r =  n1 / n2
        else if (rbMultiplica.isChecked) r =  n1 * n2

        Toast.makeText(this, "Resultado: " + r, Toast.LENGTH_LONG).show()
    }
}