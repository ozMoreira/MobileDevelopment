package br.com.laminar.beer2day

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_busca: Button = findViewById(R.id.btn_find_beer)
        btn_busca.setOnClickListener{
            busca_rotulo()
        }
    }
    fun busca_rotulo(){
        val tvw_selected_beer: TextView = findViewById(R.id.tvw_sel_brand)
        val rotulo:  Spinner =  findViewById(R.id.sp_kind_beers)
        val tv_brand: String = rotulo.selectedItem.toString()
        tvw_selected_beer.setText(tv_brand)
    }

}