package br.com.laminar.baseapp

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
        val txvUsername = findViewById<TextView>(R.id.txv_username)
        txvUsername.setText(username)

        val btnEstados = findViewById<Button>(R.id.btn_estados)
        btnEstados.setOnClickListener{
          //  irEstados()
        }

        val btnContatos = findViewById<Button>(R.id.btn_contatos)
        btnEstados.setOnClickListener{
         //   irContatos()
        }
    }
}