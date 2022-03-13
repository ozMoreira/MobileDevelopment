package br.com.laminar.checkpointum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import java.nio.file.Files

class ContaTelefonicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Checkpoint #01")

        val etAssinatura = findViewById<EditText>(R.id.et_assinatura)
        val etLocal = findViewById<EditText>(R.id.et_local)
        val etCel = findViewById<EditText>(R.id.et_cel)

        val btCalcularChamada= findViewById<Button>(R.id.bt_calcular_chamada)
        btCalcularChamada.setOnClickListener{
            calculaChamada(etAssinatura, etLocal, etCel)
        }
    }

    fun calculaChamada(etAssinatura: EditText, etLocal: EditText, etCel: EditText){

        val totalLocal: Double = etLocal.text.toString().toDouble() * 0.04
        val totalCel: Double = etCel.text.toString().toDouble() * 0.20
        val assinatura: Double = etAssinatura.text.toString().toDouble()

        var total: Double = assinatura + totalLocal + totalCel

        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("totalLocal", totalLocal.toString())
        intent.putExtra("totalCel", totalCel.toString())
        intent.putExtra("assinatura", assinatura.toString())
        intent.putExtra("total", total.toString())

        startActivity(intent)

    }
}