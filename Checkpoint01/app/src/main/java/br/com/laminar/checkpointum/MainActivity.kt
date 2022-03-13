package br.com.laminar.checkpointum

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Checkpoint #01")

        val btCalculadora= findViewById<Button>(R.id.bt_calculadora)
        btCalculadora.setOnClickListener{
            navegaClasses(btCalculadora)
        }
        val btContaTelefonica = findViewById<Button>(R.id.bt_ct_telefonica)
        btContaTelefonica.setOnClickListener{
            navegaClasses(btContaTelefonica)
        }
        val btIntegrantes= findViewById<Button>(R.id.bt_integrantes)
        btIntegrantes.setOnClickListener{
            enviaMensagem("Desenvolvido por",
            "André Hugo Bastos da Silva\n" +
                    "Matheus Ferreira Santana\n" +
                    "Oswaldo Gomes Moreira\n" +
                    "Thales Castellani")
        }
    }

    fun indicaClasse(button: Button): Class<*> {
        return when (button.id) {
            R.id.bt_calculadora -> {
                CalculadoraActivity::class.java;
            }
            R.id.bt_ct_telefonica -> {
                ContaTelefonicaActivity::class.java
            }
            else -> MainActivity::class.java
        }
    }

    fun navegaClasses(button: Button){
        val intent = Intent(this,indicaClasse(button))
        startActivity(intent)
    }

    fun enviaMensagem(titulo: String, msg: String){
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(titulo)
            .setMessage(msg)
            .setPositiveButton("OK", null)

        builder.create().show()
    }


}