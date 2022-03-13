package br.com.laminar.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt_soma: Button = findViewById(R.id.btn_somar)
        bt_soma.setOnClickListener {
            cliqueBotao()
        }
    }
    fun cliqueBotao() {
        val n1: EditText = findViewById(R.id.et_n1)
        val n2: EditText = findViewById(R.id.et_n2)
        val n3: Int =  Integer.valueOf(n1.text.toString()) + Integer.valueOf(n2.text.toString())
        exibirMensagem("Resultado", n3.toString())
    }

    fun exibirMensagem(titulo : String, mensagem : String){
        var builder = AlertDialog.Builder(this)
        builder
            .setTitle(titulo)
            .setMessage(mensagem)
            .setPositiveButton("Ok", null)
        builder.create().show()
    }
}