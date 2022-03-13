package br.com.laminar.appfiap

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCadastrar = findViewById<TextView>(R.id.tv_cadastrar)
        tvCadastrar .setOnClickListener{
            goCadastro()
        }

        val tvEsqueceu = findViewById<TextView>(R.id.tv_esqueceu)
        tvEsqueceu.setOnClickListener{
            recuperaSenha()
        }

        val btEntrar = findViewById<Button>(R.id.bt_entrar)
        btEntrar.setOnClickListener{
            val etUsername = findViewById<EditText>(R.id.et_username)
            val etSenha = findViewById<EditText>(R.id.et_senha)
            if (etUsername.text.toString().lowercase() !="admin" || etSenha.text.toString() !="123"){
                exibirMensagem("Autenticação falhou", "Usuario ou Senha Invalidos")
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username", etUsername.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

    fun exibirMensagem(titulo: String, msg: String){
        val builder = AlertDialog.Builder(this)

        builder
            .setTitle(titulo)
            .setMessage(msg)
            .setPositiveButton("OK", null)

        builder.create().show()
    }

    fun recuperaSenha(){
        val intent = Intent (this, RecuperaActivity::class.java)
        startActivity(intent)
    }

    fun goCadastro(){
        val intent = Intent (this, CadastroActivity::class.java)
        startActivity(intent)
    }
}