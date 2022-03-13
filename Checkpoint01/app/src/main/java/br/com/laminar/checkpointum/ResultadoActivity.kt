package br.com.laminar.checkpointum

import android.hardware.camera2.TotalCaptureResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val actionBar: ActionBar? = getSupportActionBar()
        if (actionBar != null) actionBar.setTitle("Checkpoint #01")

        val assinatura = intent.getStringExtra("assinatura")
        val tvAssinatura = findViewById<TextView>(R.id.tv_res_assinatura)
        tvAssinatura.text = assinatura

        val totalLocal = intent.getStringExtra("totalLocal")
        val tvTotalLocal = findViewById<TextView>(R.id.tv_res_local)
        tvTotalLocal.text = totalLocal

        val totalCel = intent.getStringExtra("totalCel")
        val tvTotalCel = findViewById<TextView>(R.id.tv_res_cel)
        tvTotalCel.text = totalCel

        val total = intent.getStringExtra("total")
        val tvTotal = findViewById<TextView>(R.id.tv_total)
        tvTotal.text = total


    }
}