
package br.com.laminar.appfiap

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.ActionBar

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val etCadUsername = findViewById<EditText>(R.id.et_cad_username)
        val etNomeCompleto = findViewById<EditText>(R.id.et_cad_nome_completo)
        val etSenha = findViewById<EditText>(R.id.et_cad_senha)
        val etConfSenha = findViewById<EditText>(R.id.et_conf_senha)
        val rbM = findViewById<RadioButton>(R.id.rb_m)
        val rbF = findViewById<RadioButton>(R.id.rb_f)
        val cbConcordo = findViewById<CheckBox>(R.id.cb_li)
        val cbReceber = findViewById<CheckBox>(R.id.cb_receber)

        val btCadastra = findViewById<Button>(R.id.bt_cadastrar)
        btCadastra.setOnClickListener{
                cadastra(etCadUsername,etNomeCompleto,etSenha,etConfSenha, rbM, rbF, cbConcordo, cbReceber)
        }
        val btVoltar = findViewById<Button>(R.id.bt_voltar)
        btVoltar.setOnClickListener{
            goMain()
        }

    }

    fun cadastra(
        etCadUsername: EditText,
        etNomeCompleto: EditText,
        etSenha: EditText,
        etConfSenha: EditText,
        rbF: RadioButton,
        rbM: RadioButton,
        cbConcordo: CheckBox,
        cbReceber: CheckBox
    ){
        if (etCadUsername.text.toString() == "" ||
            etNomeCompleto.text.toString() == "" ||
            etSenha.text.toString() == ""  ||
            etConfSenha.text.toString() == "")
                enviaMensagem("CAMPO EM BRANCO", "Preencha todos os campos do cadastro!")
        else if (!validaGenero(rbM, rbF)) enviaMensagem("GENERO EM BRANCO", "Informe seu genero!")
        else if (!validaDeAcordo(cbConcordo)) enviaMensagem("Leia os Termos", "Para efetivar o cadastro, é preciso estar de acordo com os termos!")
        else
            if(validaSenha(etSenha, etConfSenha) && isGeneroEscolhido(rbM, rbF) != ""){
                enviaMensagem("Sucesso",
                    "Username: " + etCadUsername.text.toString() +"\n" +
                            "Nome Completo: " + etNomeCompleto.text.toString() +"\n" +
                            "Senha: " + etSenha.text.toString() +"\n" +
                            "Confirmar Senha: " + etConfSenha.text.toString() +"\n"+
                            "Genero: " + isGeneroEscolhido(rbM, rbF))
                limpaForm(etCadUsername,etNomeCompleto,etSenha,etConfSenha, rbM, rbF, cbConcordo, cbReceber)
            }
            else enviaMensagem("Erro na Senha", "As senhas não coindicem! Favor confirmar senha digitada!")
    }

    fun validaDeAcordo(cbConcordo: CheckBox): Boolean{
        return cbConcordo.isChecked
    }

    fun validaGenero(rbM: RadioButton, rbF: RadioButton): Boolean{
        return rbM.isChecked or rbF.isChecked
    }

    fun validaSenha( etSenha: EditText, etConfSenha: EditText): Boolean{
        return etSenha.text.toString() == etConfSenha.text.toString()
    }

    fun isGeneroEscolhido(rbM: RadioButton, rbF: RadioButton): String{
        if (rbF.isChecked) return rbF.text.toString()
        else if (rbM.isChecked) return rbM.text.toString()
        return ""
    }

    fun enviaMensagem(titulo: String, msg: String){
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(titulo)
            .setMessage(msg)
            .setPositiveButton("OK", null)

        builder.create().show()
    }

    fun limpaForm(etCadUsername: EditText,
                  etNomeCompleto: EditText,
                  etSenha: EditText,
                  etConfSenha: EditText,
                  rbF: RadioButton,
                  rbM: RadioButton,
                  cbConcordo: CheckBox,
                  cbEmail: CheckBox){
        etCadUsername.setText("")
        etNomeCompleto.setText("")
        etSenha.setText("")
        etConfSenha.setText("")
        rbF.isChecked = false
        rbM.isChecked = false
        cbConcordo.isChecked = false
        cbEmail.isChecked = false
    }


    fun goMain(){
        val intent = Intent(this,MainActivity::class.java )
        startActivity(intent)
    }
}