package br.com.laminar.appfiap

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class RecuperaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recupera)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Recuperar Senha")

        val etEmail = findViewById<EditText>(R.id.et_email)

        val btEnviar = findViewById<Button>(R.id.bt_enviar)
        btEnviar.setOnClickListener{
            if (isEmailValido(etEmail.text)==true) enviaMensagem("Sucesso", "Email enviado para: " + etEmail.text.toString() )
            else enviaMensagem("E-mail Inválido!", "Digite um e-mail válido para recuperar sua senha!")
        }

        val btVoltar = findViewById<Button>(R.id.bt_voltar)
        btVoltar.setOnClickListener{
            goMain()
        }
    }

    fun isEmailValido(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun enviaMensagem(titulo: String, msg: String){
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(titulo)
            .setMessage(msg)
            .setPositiveButton("OK", null)

        builder.create().show()
    }

    fun goMain(){
        val intent = Intent(this,MainActivity::class.java )
        startActivity(intent)
    }
}