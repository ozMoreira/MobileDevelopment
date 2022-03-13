package br.com.laminar.baseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txvCadastrar = findViewById<TextView>(R.id.txv_cadastrar)
        txvCadastrar.setOnClickListener{
            exibirMensagem("Go to CadastrarActivity", "We are under construction")
        }

        val txvEsqueceuSenha = findViewById<TextView>(R.id.txv_esqueceu_senha)
        txvEsqueceuSenha.setOnClickListener{
            exibirMensagem("Go to EsqueceuActivity", "We are under construction")
        }

        val btnEntrar = findViewById<Button>(R.id.btn_entrar)
        btnEntrar.setOnClickListener {
            val edtUsername = findViewById<EditText>(R.id.edt_username)
            edtUsername.setText("admin")
            val edtSenha = findViewById<EditText>(R.id.edt_senha)
            edtSenha.setText("123")
            if (edtUsername.text.toString() !="admin" || edtSenha.text.toString() !="123"){
                exibirMensagem("Autenticação falhou", "Usuario ou Senha Invalidos")
            }  else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username", edtUsername.text.toString())
                startActivity(intent)
                finish()

            }
        }
    }

    //fun validaLogin(username: String, senha: String){}

    fun exibirMensagem(titulo: String, mensagem: String){
        val builder = AlertDialog.Builder(this)

        builder
            .setTitle(titulo)
            .setMessage(mensagem)
            .setPositiveButton("OK", null)

        builder
            .create()
            .show()
    }
}