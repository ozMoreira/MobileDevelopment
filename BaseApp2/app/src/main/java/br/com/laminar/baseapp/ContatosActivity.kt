package br.com.laminar.baseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.ActionBar

class ContatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contatos)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Contatos")

        val fakeApi: FakeApi = FakeApi()
        val contatos = fakeApi.getContatos()
        val adapter = findViewById<ListView>(R.id.lsv_estados)

        //val lvContatos = ArrayAdapter(this,android.R.layout.simple_list_item_1, estados)
        //lsvEstados.adapter = adapterString
    }

}