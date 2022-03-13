package br.com.laminar.baseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.ActionBar

class EstadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estados)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Estados")

        val fakeApi: FakeApi = FakeApi()
        val estados = fakeApi.getEstados()
        val lsvEstados = findViewById<ListView>(R.id.lsv_estados)

        val adapterString = ArrayAdapter(this,android.R.layout.simple_list_item_1, estados)
        lsvEstados.adapter = adapterString
    }
}