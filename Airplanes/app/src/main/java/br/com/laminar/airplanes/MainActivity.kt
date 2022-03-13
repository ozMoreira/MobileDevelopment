package br.com.laminar.airplanes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt_pa34: Button = findViewById(R.id.btn_pa34)
        bt_pa34.setOnClickListener{
            cliqueBotao(bt_pa34)
        }

        val bt_c90: Button = findViewById(R.id.btn_c90)
        bt_c90.setOnClickListener{
            cliqueBotao(bt_c90)
        }

        val bt_e121: Button = findViewById(R.id.btn_e121)
        bt_e121.setOnClickListener{
            cliqueBotao(bt_e121)
        }
    }

    fun cliqueBotao(btn: Button){
        val imgv_principal: ImageView= findViewById(R.id.iv_principal)
        if (btn.id == R.id.btn_pa34) imgv_principal.setImageResource(R.drawable.pa34)
        else if (btn.id == R.id.btn_c90) imgv_principal.setImageResource(R.drawable.c90)
        else imgv_principal.setImageResource(R.drawable.e121)
    }
}