package br.com.laminar.appfiap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.ActionBar

class ContatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contatos)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Contatos")

        val fa: FakeApi = FakeApi()
        val contatos: ArrayList<Contato> = fa.getContatos()
        val adapter = ContatosAdapter(this, contatos)

        val lvContatos = findViewById<ListView>(R.id.lv_contatos)
        lvContatos.adapter = adapter
    }
}