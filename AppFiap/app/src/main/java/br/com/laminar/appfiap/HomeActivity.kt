package br.com.laminar.appfiap


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Home")

        val username = intent.getStringExtra("username")
        val tvUsername = findViewById<TextView>(R.id.tv_bemvindo_username)
        tvUsername.text = username

        val btEstados= findViewById<Button>(R.id.bt_estados)
        btEstados.setOnClickListener{
            navegaClasses(btEstados)
        }
        val btSair = findViewById<Button>(R.id.bt_sair)
        btSair.setOnClickListener{
            navegaClasses(btSair)
        }
        val btContatos= findViewById<Button>(R.id.bt_contatos)
        btContatos.setOnClickListener{
            navegaClasses(btContatos)
        }
    }

    fun indicaClasse(button: Button): Class<*> {
        return when (button.id) {
            R.id.bt_sair -> {
                MainActivity::class.java;
            }
            R.id.bt_estados -> {
                EstadosActivity::class.java
            }
            R.id.bt_contatos -> {
                ContatosActivity::class.java
            }
            else -> HomeActivity::class.java
        }
    }

    fun navegaClasses(button: Button){
        val intent = Intent(this,indicaClasse(button))
        startActivity(intent)
        if (button.id == R.id.bt_sair) finish()
    }


}